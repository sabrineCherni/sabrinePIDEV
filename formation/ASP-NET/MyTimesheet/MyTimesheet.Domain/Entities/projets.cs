namespace MyTimesheet.Domain.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("timesheetpidev.projets")]
    public partial class projets
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public projets()
        {
            tache = new HashSet<tache>();
        }

        [Key]
        public int Projet_ID { get; set; }

        public DateTime? projet_From { get; set; }

        public DateTime? projet_To { get; set; }

        [StringLength(255)]
        public string status_projet { get; set; }

        [StringLength(255)]
        public string title_projet { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<tache> tache { get; set; }
    }
}
