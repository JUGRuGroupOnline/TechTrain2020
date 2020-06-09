using System;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;

namespace AspNetCoreCSharp.Controllers
{
	[ApiController]
	public class MainController : ControllerBase
	{
		private const string ExpectedResponse = "Мы";

		private readonly IHttpClientFactory httpClientFactory;
		private readonly AppConfiguration options;

		public MainController(IHttpClientFactory httpClientFactory,
			IOptions<AppConfiguration> options)
		{
			this.httpClientFactory = httpClientFactory;
			this.options = options.Value;
		}

		[HttpGet("/")]
		public async Task<string> Get()
		{
			string responseText = await LoadText();
			if (!responseText.Equals(ExpectedResponse, StringComparison.InvariantCultureIgnoreCase))
				throw new InvalidOperationException($"Invalid response text: {responseText}! " +
					$"Expected: {ExpectedResponse}");

			var text = " сломали";
			return responseText + text;
		}

		private async Task<string> LoadText()
		{
			var httpClient = httpClientFactory.CreateClient();
			var response = await httpClient.GetAsync(options.JavaAppUrl);
			return await response.Content.ReadAsStringAsync();
		}
	}
}
