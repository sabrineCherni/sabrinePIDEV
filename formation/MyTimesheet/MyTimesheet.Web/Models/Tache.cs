using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
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

        public int? Projet_ID { get; set; }
        [ForeignKey("employe_id")]
        public virtual Employe employe { get; set; }
        [ForeignKey("Projet_ID")]
        public virtual Projet projets { get; set; }
    }
}