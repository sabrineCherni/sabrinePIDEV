﻿using MyTimesheet.Service;
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
        {
            return View();
        }

        // GET: Projet/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Projet/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
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

        // GET: Projet/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Projet/Edit/5
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

        // GET: Projet/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Projet/Delete/5
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
