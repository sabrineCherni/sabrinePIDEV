using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.domain.Entities
{
   public class Skill
    {
        [Key]
        public int SkillId { get; set; }

        public string NomEmploye { get; set; }

        public string  TypeSkill { get; set; }

        public string NiveauSkill { get; set; }

    }
}
