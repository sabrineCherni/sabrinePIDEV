using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.web.Models
{
    public class Competence
    {
        public int CompetenceId { get; set; }
        public string CompetenceTechnique{ get; set; }

        public string CompetenceInformatique { get; set; }

        public string CompetenceCommunication { get; set; }

        public string CompetenceLogistique { get; set; }

    //    public virtual ICollection<Employe> Employes { get; set; }
    }
}
