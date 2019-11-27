using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.Domain.Entities
{
  public  class Fichemetier
    {
        public int FicheMetierId { get; set; }

        public string CompetenceRequis { get; set; }

        public string Description { get; set; }

        public string NiveauRequis { get; set; }
    }
}
