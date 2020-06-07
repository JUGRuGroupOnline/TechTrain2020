namespace AspNetCoreFSharp.Controllers

open System
open System.Net.Http
open Microsoft.AspNetCore.Mvc
open Microsoft.Extensions.Options
open AspNetCoreFSharp

[<ApiController>]
type MainController (factory : IHttpClientFactory, options: IOptions<AppConfiguration>) =
    inherit ControllerBase()

    [<HttpGet "/">]
    member __.Get() : Async<string> = async {
        let httpClient = factory.CreateClient()
        let! response = httpClient.GetAsync(options.Value.CSharpAppUrl) |> Async.AwaitTask
        response.EnsureSuccessStatusCode () |> ignore
        let! content = response.Content.ReadAsStringAsync() |> Async.AwaitTask
        if not (content.Equals "МЫ сломали") then
            new InvalidOperationException "Invalid response!" |> raise
        return content
    }
