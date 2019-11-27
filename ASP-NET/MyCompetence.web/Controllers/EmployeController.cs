using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MyCompetence.web.DAL5;
using MyCompetence.web.Models;

namespace MyCompetence.web.Controllers
{
    public class EmployeController : Controller
    {
        private MyCompetenceContext db = new MyCompetenceContext();

        // GET: Employe
        public ActionResult Index()
        {
            return View(db.Employes.ToList());
        }

        // GET: Employe/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Employe employe = db.Employes.Find(id);
            if (employe == null)
            {
                return HttpNotFound();
            }
            return View(employe);
        }

        // GET: Employe/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Employe/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "EmployeId,nom,prenom,email")] Employe employe)
        {
            if (ModelState.IsValid)
            {
                db.Employes.Add(employe);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(employe);
        }

        // GET: Employe/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Employe employe = db.Employes.Find(id);
            if (employe == null)
            {
                return HttpNotFound();
            }
            return View(employe);
        }

        // POST: Employe/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see https://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "EmployeId,nom,prenom,email")] Employe employe)
        {
            if (ModelState.IsValid)
            {
                db.Entry(employe).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(employe);
        }

        // GET: Employe/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Employe employe = db.Employes.Find(id);
            if (employe == null)
            {
                return HttpNotFound();
            }
            return View(employe);
        }

        // POST: Employe/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Employe employe = db.Employes.Find(id);
            db.Employes.Remove(employe);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
