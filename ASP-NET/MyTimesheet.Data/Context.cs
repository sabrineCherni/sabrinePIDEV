namespace MyTimesheet.Data
{
    using MyTimesheet.Domain.Entities;
    using System;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity;
    using System.Linq;

    public partial class Context : DbContext
    {
        public Context()
            : base("name=Context")
        {
        }

        public virtual DbSet<employe> employe { get; set; }
        public virtual DbSet<tache> tache { get; set; }

        public virtual DbSet<projet> projet { get; set; }
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

            modelBuilder.Entity<tache>()
                .Property(e => e.tache_ID)
                .IsUnicode(false);

            modelBuilder.Entity<tache>()
                .Property(e => e.status)
                .IsUnicode(false);

            modelBuilder.Entity<tache>()
                .Property(e => e.title)
                .IsUnicode(false);
            modelBuilder.Entity<projet>()
                .HasMany(e => e.tache)
                .WithOptional(e => e.projet)
                .HasForeignKey(e => e.projet_id);
        }
    }
}
