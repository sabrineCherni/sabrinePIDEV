using MyTimesheet.Domain.Entities;
using MyTimesheet.Service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MyTimesheet.Web.Controllers
{
    public class ProjetController : Controller
    {

        ProjetService ps;
        TacheService ts;
        public ProjetController()
        {
            ps = new ProjetService();
        }
        // GET: Projet
        public ActionResult Index()
        {
            return View(ps.GetAll());
        }
        [HttpPost]
        public ActionResult Index(string filtre)
        {
            var list = ps.GetMany();

            if (!String.IsNullOrEmpty(filtre))
            { list = list.Where(m => m.title_projet.ToString().Equals(filtre)).ToList(); }
            return View(list);
        }
        // GET: Projet/Details/5
        public ActionResult Details(int id)
        { ts = new TacheService();
            ViewBag.result = ts.GetAll().Where(x => x.projets_Projet_ID == id);
            return View(ps.GetById(id));
        }

        // GET: Projet/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Projet/Create
        [HttpPost]
        public ActionResult Create(projets p)
        {
            try
            {
                // TODO: Add insert logic here
                
                ps.Add(p);
                ps.Commit();

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Projet/Edit/5
        public ActionResult Edit(int id)
        {
            return View(ps.GetById(id));
        }

        // POST: Projet/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, projets p)
        {
            try
            {
                // TODO: Add update logic here
                ps.Update(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Projet/Delete/5
        public ActionResult Delete(int id)
        {
            projets p = ps.GetById(id);


            if (p == null)
            {
                return HttpNotFound();
            }

            return View(p);
        }

        // POST: Projet/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, projets p)
        {
            try
            {
                // TODO: Add delete logic here
                p = ps.GetById(id);
                ps.Delete(p);
                ps.Commit();
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        public ActionResult Indexcharts()
        {
            return View();
        }
        public ActionResult GetData()
        {
            int TO_DO = ps.GetAll().Where(x => x.status_projet == "TO_DO").Count();
            int DONE = ps.GetAll().Where(x => x.status_projet == "DONE").Count();
            int IN_PROGRESS = ps.GetAll().Where(x => x.status_projet == "IN_PROGRESS").Count();
            Ratio obj = new Ratio();
            obj.TO_DO = TO_DO;
            obj.DONE = DONE;
            obj.IN_PROGRESS = IN_PROGRESS;

            return Json(obj, JsonRequestBehavior.AllowGet);
        }
        public class Ratio
        {
            public int TO_DO { get; set; }
            public int DONE { get; set; }
            public int IN_PROGRESS { get; set; }
        }
    }
}
