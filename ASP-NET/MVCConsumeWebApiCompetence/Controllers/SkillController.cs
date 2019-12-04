using MyCompetence.domain.Entities;
using MyCompetence.service;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCConsumeWebApiCompetence.Controllers
{
    public class SkillController : Controller
    {

        public SkillService fs;
        public SkillController()
        {
            fs = new SkillService();
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
            fs = new SkillService();
            var skills = fs.GetMany();
            ViewBag.SkillId = new SelectList(skills, "SkillId", "NomEmploye");
            return View();
        }

        // POST: Fichemetier/Create
        [HttpPost]
        public ActionResult Create(Skill p)
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
        public ActionResult Edit(int id, Skill p1)
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
            Skill p = fs.GetById(id);


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
            Skill p1 = fs.GetById(id);
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
        public ActionResult Charts()
        {
            return View();
        }
        public ActionResult GetData()
        {
            int Bien = fs.GetAll().Where(x => x.NiveauSkill == "Bien").Count();
            int Moyen = fs.GetAll().Where(x => x.NiveauSkill == "Moyen").Count();
            int Mauvais = fs.GetAll().Where(x => x.NiveauSkill == "Mauvais").Count();
            Ratio obj = new Ratio();
            obj.Bien = Bien;
            obj.Moyen = Moyen;
            obj.Mauvais = Mauvais;

            return Json(obj, JsonRequestBehavior.AllowGet);
        }
        public class Ratio
        {
            public int Bien { get; set; }
            public int Moyen { get; set; }
            public int Mauvais { get; set; }
        }
    }
}