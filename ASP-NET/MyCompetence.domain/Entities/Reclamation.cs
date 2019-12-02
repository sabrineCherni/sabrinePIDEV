using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.domain.Entities
{
   public class Reclamation
    {
        [Key]
        public int ReclamationId { get; set; }

        public string Titre { get; set; }

        public string Description { get; set; }

    }
}
