namespace MyCompetence.data
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using MyCompetence.Domain.Entities;
    using MyCompetence.domain.Entities;

    public partial class Context : DbContext
    {
        public Context()
            : base("name=Context")
        {
        }

        public virtual DbSet<employe> employes { get; set; }
        public virtual DbSet<t_communication> t_communication { get; set; }
        public virtual DbSet<t_competence> t_competence { get; set; }
        public virtual DbSet<t_formation> t_formation { get; set; }
        public virtual DbSet<t_manager> t_manager { get; set; }
        public virtual DbSet<t_quiz> t_quiz { get; set; }
       public virtual DbSet<Fichemetier> Fichemetiers { get; set; }

        public virtual DbSet<Reclamation> Reclamations { get; set; }

        public virtual DbSet<Skill> Skills { get; set; }
        //   public virtual DbSet<Formation> Formations { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<employe>()
                .Property(e => e.email)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .Property(e => e.grade)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .Property(e => e.nom)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .Property(e => e.password)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .Property(e => e.prenom)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .Property(e => e.role)
                .IsUnicode(false);

            modelBuilder.Entity<employe>()
                .HasMany(e => e.t_competence)
                .WithMany(e => e.employes)
                .Map(m => m.ToTable("employe_t_competence", "competence").MapLeftKey("employes_id").MapRightKey("competences_id"));

            modelBuilder.Entity<t_communication>()
                .Property(e => e.linguistique)
                .IsUnicode(false);

            modelBuilder.Entity<t_communication>()
                .Property(e => e.nom_employe)
                .IsUnicode(false);

            modelBuilder.Entity<t_communication>()
                .Property(e => e.socio_culturelle)
                .IsUnicode(false);

            modelBuilder.Entity<t_communication>()
                .Property(e => e.socio_linguistique)
                .IsUnicode(false);

            modelBuilder.Entity<t_communication>()
                .Property(e => e.strategique)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .Property(e => e.aptitude)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .Property(e => e.nom_employe)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .Property(e => e.savoir)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .Property(e => e.savoi_faire_operationnel)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .Property(e => e.savoir_faire_relationnel)
                .IsUnicode(false);

            modelBuilder.Entity<t_competence>()
                .HasMany(e => e.employes1)
                .WithMany(e => e.t_competence1)
                .Map(m => m.ToTable("t_competence_employe", "competence").MapLeftKey("Competence_id").MapRightKey("employes_id"));

            modelBuilder.Entity<t_formation>()
                .Property(e => e.nom_employe)
                .IsUnicode(false);

            modelBuilder.Entity<t_manager>()
                .Property(e => e.email)
                .IsUnicode(false);

            modelBuilder.Entity<t_manager>()
                .Property(e => e.grade)
                .IsUnicode(false);

            modelBuilder.Entity<t_manager>()
                .Property(e => e.nom)
                .IsUnicode(false);

            modelBuilder.Entity<t_manager>()
                .Property(e => e.prenom)
                .IsUnicode(false);

            modelBuilder.Entity<t_quiz>()
                .Property(e => e.question)
                .IsUnicode(false);

            modelBuilder.Entity<t_quiz>()
                .Property(e => e.reponse)
                .IsUnicode(false);
        }

        
    }
}
