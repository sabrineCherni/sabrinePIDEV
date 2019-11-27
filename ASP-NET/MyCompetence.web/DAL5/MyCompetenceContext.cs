
using MyCompetence.web.Models;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.web.DAL5
{
   public class MyCompetenceContext : DbContext
    {
        public MyCompetenceContext() : base("name=MaChaine")
        {

        }
        public DbSet<Competence> Competences { get; set; }

        public DbSet<Employe> Employes { get; set; }

        public DbSet<Fichemetier> Fichemetiers { get; set; }

        public DbSet<Manager> Managers { get; set; }

       /* protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
        }*/


    }

    }

