namespace fsharp3.Controllers

open System
open System.Collections.Generic
open System.Linq
open System.Threading.Tasks
open Microsoft.AspNetCore.Mvc
open Microsoft.Extensions.Logging
open fsharp3
open System.Net.Http

[<ApiController>]
[<Route("third")>]
type WeatherForecastController (logger : ILogger<WeatherForecastController>) =
    inherit ControllerBase()

    [<HttpGet>]
    member __.Get() : string =
        let client = new HttpClient()
        let res = client.GetStringAsync("http://localhost:8282/second").GetAwaiter().GetResult()
        if String.Equals(res, "Мы сломали", StringComparison.InvariantCultureIgnoreCase)
        then res + " твой"
        else ""
