using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyTimesheet.Domain.Entities
{
    public class projet
    {
        [Key]
        public int projet_ID { get; set; }
        public string title_projet { get; set; }
        public DateTime? projet_From { get; set; }
        public DateTime? projet_To { get; set; }

        public virtual ICollection<tache> tache { get; set; }
    }
}
