using MyCompetence.Data.Infrastructure;
using MyCompetence.Domain.Entities;
using MyCompetence.ServicePattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.service
{
    public class FichemetierService : Service<Fichemetier>, IFichemetierService
    {

        static IDatabaseFactory factory = new DatabaseFactory();
        static IUnitOfWork UOW = new UnitOfWork(factory);
        public FichemetierService():base(UOW)
        {

        }

    }
}
