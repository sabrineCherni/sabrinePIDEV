using MyCompetence.data;
using MyCompetence.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.console
{
    class Program
    {
        static void Main(string[] args)
        {

            Employe p = new Employe() { nom = "asus" };

            MyCompetenceContext ctx = new MyCompetenceContext();
            ctx.Employes.Add(p);
            ctx.SaveChanges();
            Console.WriteLine("fin");
            Console.ReadKey();


        }
    }
}
