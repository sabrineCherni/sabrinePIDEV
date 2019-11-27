namespace MyCompetence.data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("competence.t_formation")]
    public partial class t_formation
    {
        public int id { get; set; }

        [StringLength(255)]
        public string nom_employe { get; set; }
    }
}
