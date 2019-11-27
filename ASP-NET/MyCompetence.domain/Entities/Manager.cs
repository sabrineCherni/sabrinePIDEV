using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.Domain.Entities
{
   public class Manager
    {
        public int ManagerId { get; set; }
        public string nom { get; set; }
        public string prenom { get; set; }
        public string email { get; set; }
    }
}
