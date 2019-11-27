namespace MyCompetence.data
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("competence.t_quiz")]
    public partial class t_quiz
    {
        public int id { get; set; }

        [StringLength(255)]
        public string question { get; set; }

        [StringLength(255)]
        public string reponse { get; set; }
    }
}
