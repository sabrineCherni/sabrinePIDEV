namespace MyTimesheet.Domain.Entities
{
    
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("timesheetpidev.tache")]
    public partial class tache
    {
        [Key]
        [StringLength(255)]
        public string tache_ID { get; set; }

        public DateTime? valueFrom { get; set; }

        [StringLength(255)]
        public string status { get; set; }

        [StringLength(255)]
        public string title { get; set; }

        public DateTime? valueTo { get; set; }

        public int? employe_id { get; set; }

        public int? projet_id { get; set; }

        public virtual employe employe { get; set; }
        public virtual projet projet { get; set; }
    }
}
