using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;

namespace csharp2.Controllers
{
    [ApiController]
    [Route("second")]
    public class WeatherForecastController : ControllerBase
    {
        [HttpGet]
        public async Task<string> Get()
        {
	try{
            var res = await new HttpClient().GetStringAsync("http://localhost:8080/");
            if (String.Equals(res, "Мы", StringComparison.InvariantCultureIgnoreCase))
            {
                return res + " сломали";
            }
            return "not equals";
}
catch(Exception e){
return "Exception" + e.ToString();
}
        }
    }
}
