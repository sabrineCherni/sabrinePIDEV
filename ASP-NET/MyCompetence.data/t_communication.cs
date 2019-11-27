namespace MyCompetence.data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("competence.t_communication")]
    public partial class t_communication
    {
        public int id { get; set; }

        [StringLength(255)]
        public string linguistique { get; set; }

        [StringLength(255)]
        public string nom_employe { get; set; }

        [StringLength(255)]
        public string socio_culturelle { get; set; }

        [StringLength(255)]
        public string socio_linguistique { get; set; }

        [StringLength(255)]
        public string strategique { get; set; }
    }
}
