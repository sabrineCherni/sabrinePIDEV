namespace MyTimesheet.Data
{
    using System;
    using System.Data.Entity;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Linq;
    using MyTimesheet.Domain.Entities;

    public partial class Context : DbContext
    {
        public Context()
            : base("name=Context")
        {
        }

        public virtual DbSet<employe> employe { get; set; }
        public virtual DbSet<projets> projets { get; set; }
        public virtual DbSet<tache> tache { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Entity<employe>()
                .Property(e => e.email)
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
                .HasMany(e => e.tache)
                .WithOptional(e => e.employe)
                .HasForeignKey(e => e.employe_id);

            modelBuilder.Entity<projets>()
                .Property(e => e.status_projet)
                .IsUnicode(false);

            modelBuilder.Entity<projets>()
                .Property(e => e.title_projet)
                .IsUnicode(false);

            modelBuilder.Entity<projets>()
                .HasMany(e => e.tache)
                .WithOptional(e => e.projets)
                .HasForeignKey(e => e.projets_Projet_ID);

            modelBuilder.Entity<tache>()
                .Property(e => e.tache_ID)
                .IsUnicode(false);

            modelBuilder.Entity<tache>()
                .Property(e => e.status)
                .IsUnicode(false);

            modelBuilder.Entity<tache>()
                .Property(e => e.title)
                .IsUnicode(false);
        }
    }
}
