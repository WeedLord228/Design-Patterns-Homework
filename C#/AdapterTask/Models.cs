using System;
using System.Collections.Generic;
using System.Text;

namespace AdapterTask.Models
{
    public interface IDbEntity
    {
        int Id { get; set; }
    }

    public class DbUserInfoEntity : IDbEntity
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public DateTime Birthday { get; set; }
    }

    public class DbUserEntity : IDbEntity
    {
        public int Id { get; set; }
        public string Login { get; set; }
        public string PasswordHash { get; set; }
        public int InfoId { get; set; }
    }
}
