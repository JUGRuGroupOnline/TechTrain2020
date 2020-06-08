// /*----------------------------------------------------------
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v.2.0. If a copy of the MPL
// was not distributed with this file, You can obtain one
// at http://mozilla.org/MPL/2.0/.
// ----------------------------------------------------------*/

using System;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace JugRu_Challenge2.Controllers
{
    [ApiController]
    [Route("/")]
    public class ChainEndpointController : Controller
    {     
        // GET
        [HttpGet]
        public async Task<IActionResult> Get()
        {
            var url = Environment.GetEnvironmentVariable("SERVICE_ENTRYPOINT");
            if (string.IsNullOrEmpty(url))
            {
                return StatusCode(500, "Переменная среды не задана: SERVICE_ENTRYPOINT");
            }
            var standartAnswer = "Мы";
            var client = new HttpClient();
            var response = await client.GetAsync(url);
            if (response.StatusCode == HttpStatusCode.OK)
            {
                var data = await response.Content.ReadAsStringAsync();
                if (data != standartAnswer)
                {
                    return StatusCode(500, $"Ответ не соответствует ожидаемому значению: {standartAnswer}");
                }

                return Content(data + " сломали", "text/plain", Encoding.UTF8);
            }
            else
                return StatusCode((int)response.StatusCode);

            
        }
    }
}