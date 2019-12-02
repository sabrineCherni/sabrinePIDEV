using MVCConsumeWebApiCompetence.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;

namespace MVCConsumeWebApiCompetence.Controllers
{
    public class FormationController : Controller
    {
        // GET: Formation
        public ActionResult Index()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/formations").Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<IEnumerable<Formation>>().Result;
            }
            else
            {
                ViewBag.result = "error";
            }
            return View();

        }
        [HttpGet]
        public ActionResult Create()
        {
            return View("Create");
        }
        [HttpPost]
        public ActionResult Create(Formation evm)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            client.PostAsJsonAsync<Formation>("api/formations", evm).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());



            return RedirectToAction("Index");
        }

        // GET: Employe/Edit/5
        [HttpGet]
        public ActionResult Edit(int id)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/formations/" + id).Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<Formation>().Result;
            }
            else
            {
                ViewBag.result = "error";
            }

            return View(ViewBag.result);
        }

        // POST: Employe/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Formation evm)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");

            client.PutAsJsonAsync("api/formations", evm).ContinueWith((putTask) => putTask.Result.EnsureSuccessStatusCode());

            return RedirectToAction("Index");

        }
        // GET: Employe/Delete/5
        public ActionResult Delete(int id)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/formations/" + id).Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<Formation>().Result;
            }
            else
            {
                return HttpNotFound();
            }


            return View(ViewBag.result);
        }


        // POST: Employe/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Formation emp)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");

            client.DeleteAsync("api/formations/" + id).ContinueWith((deleteTask) => deleteTask.Result.EnsureSuccessStatusCode());


            return RedirectToAction("Index");
        }
    }
}