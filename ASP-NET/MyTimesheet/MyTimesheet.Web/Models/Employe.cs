using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MyTimesheet.Web.Models
{
    public class Employe
    {
        public int id { get; set; }
        public string nom { get; set; }
        public string prenom { get; set; }
        public string email { get; set; }
    }
}