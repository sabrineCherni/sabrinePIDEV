using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.Domain.Entities
{
  public  class Fichemetier
    {
        [Key]
        public int FicheMetierId { get; set; }

        public string CompetenceRequis { get; set; }

        public string Description { get; set; }

        public string NiveauRequis { get; set; }
    }
}
