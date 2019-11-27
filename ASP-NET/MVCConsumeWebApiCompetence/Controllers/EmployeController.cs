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
    public class EmployeController : Controller
    {
        // GET: Employe
        public ActionResult Index() 
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/users").Result;
            if(response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<IEnumerable<Employe>>().Result;
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
        public ActionResult Create(Employe evm)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");

            client.PostAsJsonAsync<Employe>("api/users", evm).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());
           
            return RedirectToAction("Index");
        }

        // GET: Employe/Edit/5
        [HttpGet]
        public ActionResult Edit(int id)
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/users/" + id).Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<Employe>().Result;
            }
            else
            {
                ViewBag.result = "error";
            }

            return View(ViewBag.result);
        }

        // POST: Employe/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Employe evm)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");

            client.PutAsJsonAsync<Employe>("api/users", evm).ContinueWith((putTask) => putTask.Result.EnsureSuccessStatusCode());

            return RedirectToAction("Index");

        }
            // GET: Employe/Delete/5
        public ActionResult Delete(int id)
            {
                HttpClient Client = new HttpClient();
                Client.BaseAddress = new Uri("http://localhost:9080/competence-web/");
                Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage response = Client.GetAsync("api/users/" + id).Result;
                if (response.IsSuccessStatusCode)
                {

                    ViewBag.result = response.Content.ReadAsAsync<Employe>().Result;
                }
                else
                {
                    return HttpNotFound();
                }


                return View(ViewBag.result);
            }


        // POST: Employe/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, Employe emp)
        {
            HttpClient client = new HttpClient();
            client.BaseAddress = new Uri("http://localhost:9080/competence-web/");

            client.DeleteAsync("api/users/" + id).ContinueWith((deleteTask) => deleteTask.Result.EnsureSuccessStatusCode());


            return RedirectToAction("Index");
        }







    }
}