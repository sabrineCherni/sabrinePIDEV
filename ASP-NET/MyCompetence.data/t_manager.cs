namespace MyCompetence.data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("competence.t_manager")]
    public partial class t_manager
    {
        public int id { get; set; }

        [StringLength(255)]
        public string email { get; set; }

        [StringLength(255)]
        public string grade { get; set; }

        [StringLength(255)]
        public string nom { get; set; }

        [StringLength(255)]
        public string prenom { get; set; }
    }
}
