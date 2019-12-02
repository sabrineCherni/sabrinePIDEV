using MyCompetence.Data.Infrastructure;
using MyCompetence.domain.Entities;
using MyCompetence.ServicePattern;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.service
{
    public class ReclamationService : Service<Reclamation>, IReclamationService
    {

        static IDatabaseFactory factory = new DatabaseFactory();
        static IUnitOfWork UOW = new UnitOfWork(factory);
        public ReclamationService() : base(UOW)
        {

        }

    }
}
