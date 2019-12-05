using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MVCConsumeWebApiCompetence.Models
{
    public class Formation
    {
        public int id { get; set; }

        [Required, StringLength(4, ErrorMessage = "inférieur a 25!!"), MaxLength(50)]
        public string formationc { get; set; }

    }
}