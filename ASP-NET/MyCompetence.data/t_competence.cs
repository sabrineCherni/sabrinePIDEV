namespace MyCompetence.data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("competence.t_competence")]
    public partial class t_competence
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public t_competence()
        {
            employes = new HashSet<employe>();
            employes1 = new HashSet<employe>();
        }

        public int id { get; set; }

        [StringLength(255)]
        public string aptitude { get; set; }

        [StringLength(255)]
        public string nom_employe { get; set; }

        [StringLength(255)]
        public string savoir { get; set; }

        [StringLength(255)]
        public string savoi_faire_operationnel { get; set; }

        [StringLength(255)]
        public string savoir_faire_relationnel { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<employe> employes { get; set; }

        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<employe> employes1 { get; set; }
    }
}
