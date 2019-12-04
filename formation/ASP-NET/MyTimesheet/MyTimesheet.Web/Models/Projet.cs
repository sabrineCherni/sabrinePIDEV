using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MyTimesheet.Web.Models
{
    public class Projet
    {
        [Key]
        public int id { get; set; }
    }
}