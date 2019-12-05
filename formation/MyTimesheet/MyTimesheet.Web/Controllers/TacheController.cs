using MyTimesheet.Service;
using MyTimesheet.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Web;
using System.Web.Mvc;

namespace MyTimesheet.Web.Controllers
{
    public class TacheController : Controller
    {
        TacheService ts;
        ProjetService ps;
        public TacheController()
        {
            ts = new TacheService();
        }
        // GET: Tache
        public ActionResult Index()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/timesheet-pidev-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/taches").Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<IEnumerable<Tache>>().Result.Where(x => x.projets == null);
            }
            else
            {
                ViewBag.result = "error";
            }
            return View(ViewBag.result);
        }
        public ActionResult Indexdel()
        {
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/timesheet-pidev-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/taches").Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<IEnumerable<Tache>>().Result.Where(x => x.projets != null);
            }
            else
            {
                ViewBag.result = "error";
            }
            return View(ViewBag.result);
        }
        // GET: Tache/Create

        public ActionResult CreateP(int id)
        {
            Tache t = new Tache();
            HttpClient Client = new HttpClient();
            Client.BaseAddress = new Uri("http://localhost:9080/timesheet-pidev-web/");
            Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
            HttpResponseMessage response = Client.GetAsync("api/taches/" + id).Result;
            if (response.IsSuccessStatusCode)
            {

                ViewBag.result = response.Content.ReadAsAsync<Tache>().Result;
                
                t = ViewBag.result;
            }
            else
            {
                return HttpNotFound();
            }
            ps = new ProjetService();
            var Projets = ps.GetMany();
            ViewBag.Projet_ID = new SelectList(Projets, "Projet_ID", "title_projet");

            return View(t);
        }

        // POST: Tache/Create
        [HttpPost]
        public ActionResult CreateP(int id,Tache tach)
        {
            try
            {
                // TODO: Add insert logic here
                HttpClient Client = new HttpClient();
                Client.BaseAddress = new Uri("http://localhost:9080/timesheet-pidev-web/");
                Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
                HttpResponseMessage response = Client.GetAsync("api/taches/" + id+"/"+tach.Projet_ID).Result;
                if (response.IsSuccessStatusCode)
                {

                    ViewBag.result = response.Content.ReadAsAsync<Tache>().Result;

                    
                }
                else
                {
                    return HttpNotFound();
                }

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Tache/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Tache/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Tache/Create
        [HttpPost]
        public ActionResult Create(Tache tac)
        {
            try
            {
                HttpClient client = new HttpClient();
                client.BaseAddress = new Uri("http://localhost:9080/timesheet-pidev-web/");

                client.PostAsJsonAsync<Tache>("api/taches",tac ).ContinueWith((postTask) => postTask.Result.EnsureSuccessStatusCode());

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Tache/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Tache/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Tache/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Tache/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
