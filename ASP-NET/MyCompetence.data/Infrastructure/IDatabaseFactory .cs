
using MyCompetence.data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyCompetence.Data.Infrastructure
{
    public interface IDatabaseFactory : IDisposable
    {
        Context DataContext { get; }
    }

}
