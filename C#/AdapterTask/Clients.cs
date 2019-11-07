using AdapterTask.FirstOrmLibrary;
using AdapterTask.Models;
using AdapterTask.SecondOrmLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AdapterTask
{
    public class FirstOrmAdapter : IOrmAdapter
    {
        private IFirstOrm<DbUserEntity> _firstOrm1;
        private IFirstOrm<DbUserInfoEntity> _firstOrm2;

        public FirstOrmAdapter(IFirstOrm<DbUserEntity> _firstOrm1,IFirstOrm<DbUserInfoEntity> _firstOrm2 )
        {
            this._firstOrm1 = _firstOrm1;
            this._firstOrm2 = _firstOrm2;
        }

        public void Add(DbUserEntity user, DbUserInfoEntity userInfo)
        {
            _firstOrm1.Add(user);
            _firstOrm2.Add(userInfo);
        }

        public (DbUserEntity, DbUserInfoEntity) Get(int userId)
        {
            var user = _firstOrm1.Read(userId);
            var userInfo = _firstOrm2.Read(user.InfoId);
            return (user, userInfo);
        }

        public void Remove(int userId)
        {
            var user = _firstOrm1.Read(userId);
            var userInfo = _firstOrm2.Read(user.InfoId);

            _firstOrm2.Delete(userInfo);
            _firstOrm1.Delete(user);
        }
    }

    public class SecondOrmAdapter : IOrmAdapter
    {
        private ISecondOrm _secondOrm;

        public SecondOrmAdapter (ISecondOrm _secondOrm)
        {
            this._secondOrm = _secondOrm;
        } 

        public void Add(DbUserEntity user, DbUserInfoEntity userInfo)
        {
            _secondOrm.Context.Users.Add(user);
            _secondOrm.Context.UserInfos.Add(userInfo);
        }

        public (DbUserEntity, DbUserInfoEntity) Get(int userId)
        {
            var user = _secondOrm.Context.Users.First(i => i.Id == userId);
            var userInfo = _secondOrm.Context.UserInfos.First(i => i.Id == user.InfoId);
            return (user, userInfo);
        }

        public void Remove(int userId)
        {
            var user = _secondOrm.Context.Users.First(i => i.Id == userId);
            var userInfo = _secondOrm.Context.UserInfos.First(i => i.Id == user.InfoId);

            _secondOrm.Context.UserInfos.Remove(userInfo);
            _secondOrm.Context.Users.Remove(user);
        }
    }

    public interface IOrmAdapter // ITarget
    {
        (DbUserEntity, DbUserInfoEntity) Get(int userId);
        void Add(DbUserEntity user, DbUserInfoEntity userInfo);
        void Remove(int userId);

    }

    public class UserClient
    {
        private IOrmAdapter _ormAdapter;

        private bool _useFirstOrm = true;

        public (DbUserEntity, DbUserInfoEntity) Get(int userId)
        {
            return _ormAdapter.Get(userId);
        }

        public void Add(DbUserEntity user, DbUserInfoEntity userInfo)
        {
            _ormAdapter.Add(user, userInfo);
        }

        public void Remove(int userId)
        {
            _ormAdapter.Remove(userId);
        }

        public UserClient(IOrmAdapter ormAdapter)
        {
            _ormAdapter = ormAdapter;
        }
    }

}
