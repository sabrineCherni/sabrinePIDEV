using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MyTimesheet.Web.Models
{
    public class Tache
    {
        [Key]
        public int id { get; set; }
        public string title { get; set; }
        public string status { get; set; }
        public string from { get; set; }
        public string to { get; set; }
        public int? employe_id { get; set; }

        public int? projets_Projet_ID { get; set; }

        public virtual Employe employe { get; set; }

        public virtual Projet projets { get; set; }
    }
}