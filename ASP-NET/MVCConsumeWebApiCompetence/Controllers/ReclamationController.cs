using MyCompetence.domain.Entities;
using MyCompetence.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCConsumeWebApiCompetence.Controllers
{
    public class ReclamationController : Controller
    {

        public ReclamationService fs;
        public ReclamationController()
        {
            fs = new ReclamationService();
        }

        [HttpGet]
        public ActionResult Index()
        {
            return View(fs.GetAll());
        }

        [HttpPost]
        public ActionResult Index(string filtre)
        {
            var list = fs.GetMany();

            if (!String.IsNullOrEmpty(filtre))
            { list = list.Where(m => m.Titre.ToString().Equals(filtre)).ToList(); }
            return View(list);
        }



        // GET: Fichemetier/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Fichemetier/Create
        public ActionResult Create()
        {
            fs = new ReclamationService();
            var reclamations = fs.GetMany();
            ViewBag.ReclamationId = new SelectList(reclamations, "ReclamationId", "Titre","Description");
            return View();
        }

        // POST: Fichemetier/Create
        [HttpPost]
        public ActionResult Create(Reclamation p)
        {
            fs.Add(p);
            fs.Commit();

            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Fichemetier/Edit/5
        [HttpGet]
        public ActionResult Edit(int id)
        {
             return View(fs.GetById(id));




           
        }

        // POST: Fichemetier/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Reclamation p1)
        {

            fs.Update(p1);
            fs.Commit();


            try
            {
                // TODO: Add update logic here
          //      p1 = fs.GetById(id);

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Fichemetier/Delete/5
        public ActionResult Delete(int id)
        {
            Reclamation p = fs.GetById(id);


            if (p == null)
            {
                return HttpNotFound();
            }


            return View(p);
        }

        // POST: Fichemetier/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            Reclamation p1 = fs.GetById(id);
            fs.Delete(p1);
            fs.Commit();
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