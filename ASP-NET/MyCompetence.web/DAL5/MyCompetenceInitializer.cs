using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data.Entity;
using MyCompetence.web.Models;

namespace MyCompetence.web.DAL5
{
    public class MyCompetenceInitializer : System.Data.Entity.DropCreateDatabaseIfModelChanges<MyCompetenceContext>
    {
        protected override void Seed(MyCompetenceContext context)
        {
            var employes = new List<Employe>
            {
            new Employe{nom="Carson",prenom="Alexander",email="gg"},
            new Employe{nom="Carson1",prenom="Alexander1",email="gg1"},
            };

            employes.ForEach(s => context.Employes.Add(s));
            context.SaveChanges();
           
        }
    }
}