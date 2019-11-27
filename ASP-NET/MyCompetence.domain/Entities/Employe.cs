using MyCompetence.Domain.Entities;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MyCompetence.Domain.Entities
{
    public class Employe
    {
        public int EmployeId { get; set; }
        public string nom{ get; set; }
        public string prenom { get; set; }
        public string email { get; set; }
        public virtual ICollection<Competence> Competences { get; set; }

    }
}