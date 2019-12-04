using MyCompetence.Domain.Entities;
using MyCompetence.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCConsumeWebApiCompetence.Controllers
{ 
    public class FichemetierController : Controller
    {

        public FichemetierService fs;
        public FichemetierController()
        {
            fs = new FichemetierService();
        }

        [HttpGet]
        public ActionResult Index()
        {
            return View(fs.GetAll());
        }

        // GET: Fichemetier/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Fichemetier/Create
        public ActionResult Create()
        {
            fs = new FichemetierService();
            var fichemetiers = fs.GetMany();
            ViewBag.FicheMetierId = new SelectList(fichemetiers, "FicheMetierId", "CompetenceRequis");
            return View();
        }

        // POST: Fichemetier/Create
        [HttpPost]
        public ActionResult Create(Fichemetier p)
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
        public ActionResult Edit(int id)
        {
            //  Fichemetier p = fs.GetById(id);
            /* fs = new FichemetierService();
             var fichemetiers = fs.GetById(id);
             ViewBag.FicheMetierId = new SelectList(fichemetiers, "FicheMetierId", "CompetenceRequis");*/
            return View(fs.GetById(id));




            /*      fs = new FichemetierService();
                  var fichemetiers = fs.GetMany();
                  ViewBag.FicheMetierId = new SelectList(fichemetiers, "FicheMetierId", "CompetenceRequis"); 
                  return View();*/
        }

        // POST: Fichemetier/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Fichemetier p1)
        {


            fs.Update(p1);
            fs.Commit();

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

        // GET: Fichemetier/Delete/5
        public ActionResult Delete(int id)
        {
            Fichemetier p = fs.GetById(id);


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
            Fichemetier p1 = fs.GetById(id);
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