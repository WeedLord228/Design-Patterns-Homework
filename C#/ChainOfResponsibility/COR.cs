using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ChainOfResponsibility
{
    public enum CurrencyType
    {
        Eur,
        Dollar,
        Ruble
    }

    public interface IBanknote
    {
        CurrencyType Currency { get; }
        string Value { get; }
    }

    public class Bancomat
    {
        private readonly BanknoteHandler _handler;

        public Bancomat()
        {
            _handler = new FiveEuroHandler(null);
            _handler = new TenEuroHandler(_handler);
            _handler = new TwentyEuroHandler(_handler);
            _handler = new FiftyEuroHandler(_handler);
            _handler = new HundredEuroHandler(_handler);
            _handler = new TwoHundredEuroHandler(_handler);
            _handler = new OneDollarHandler(_handler);
            _handler = new TwoDollarHandler(_handler);
            _handler = new FiveDollarHandler(_handler);
            _handler = new TenDollarHandler(_handler);
            _handler = new TwentyDollarHandler(_handler);
            _handler = new FiftyDollarHandler(_handler);
            _handler = new HundredDollarHandler(_handler);
            _handler = new TenRubelesHandler(_handler);
            _handler = new FiftyRubelesHandler(_handler);
            _handler = new HundredRubelesHandler(_handler);
            _handler = new TwoHundredRubelesHandler(_handler);
            _handler = new FiveHundredRubelesHandler(_handler);
            _handler = new ThousandRubelesHandler(_handler);
            _handler = new TwoThousandRubelesHandler(_handler);
            _handler = new FiveThousandRubelesHandler(_handler);
        }

        public bool Validate(string banknote)
        {
            return _handler.Validate(banknote);
        }

        public bool CashOut(int amount, CurrencyType currency)
        {
            return _handler.CashOut(amount, currency);
        }
    }

    public abstract class BanknoteHandler
    {
        private readonly BanknoteHandler _nextHandler;

        protected BanknoteHandler(BanknoteHandler nextHandler)
        {
            _nextHandler = nextHandler;
        }

        public virtual bool Validate(string banknote)
        {
            return _nextHandler != null && _nextHandler.Validate(banknote);
        }

        //Обналичивает купюры, возвращает true, если смог обналичить, false если не смог обналичить 
        public virtual bool CashOut(int amount,CurrencyType currency)
        {
            return _nextHandler != null && _nextHandler.CashOut(amount, currency);
        }

    }

    public abstract class DollarHandlerBase : BanknoteHandler
    {
        public override bool Validate(string banknote)
        {
            if (banknote.Equals($"{Value}$ долларов"))
            {
                return true;
            }
            return base.Validate(banknote);
        }

        protected abstract int Value { get; }

        public override bool CashOut(int amount, CurrencyType currency)
        {
            if (currency == CurrencyType.Dollar && (amount == Value || amount == 0))
                return true;
            else
            {
                return base.CashOut(amount - ((amount / Value) * Value), currency);
            }
        }

            protected DollarHandlerBase(BanknoteHandler nextHandler) : base(nextHandler)
        {
        }
    }

    public abstract class RubelesHandlerBase : BanknoteHandler
    {
        public override bool Validate(string banknote)
        {
            if (banknote.Equals($"{Value}$ рублей"))
            {
                return true;
            }
            return base.Validate(banknote);
        }

        protected abstract int Value { get; }

        public override bool CashOut(int amount, CurrencyType currency)
        {
            if (currency == CurrencyType.Ruble && (amount == Value || amount == 0))
                return true;
            else
            {
                return base.CashOut(amount - ((amount / Value) * Value), currency);
            }
        }

        protected RubelesHandlerBase(BanknoteHandler nextHandler) : base(nextHandler)
        {
        }
    }

    public abstract class EuroHandlerBase : BanknoteHandler
    {
        public override bool Validate(string banknote)
        {
            if (banknote.Equals($"{Value}$ евро"))
            {
                return true;
            }
            return base.Validate(banknote);
        }

        protected abstract int Value { get; }

        public override bool CashOut(int amount, CurrencyType currency)
        {
            if (currency == CurrencyType.Eur && (amount == Value || amount == 0))
                return true;
            else
            {
                return base.CashOut(amount - ((amount / Value) * Value), currency);
            }
        }

        protected EuroHandlerBase(BanknoteHandler nextHandler) : base(nextHandler)
        {
        }
    }

    public class HundredDollarHandler : DollarHandlerBase
    {
        protected override int Value => 100;

        public HundredDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }

    }

    public class FiftyDollarHandler : DollarHandlerBase
    {
        protected override int Value => 50;

        public FiftyDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }
    }

    public class TwentyDollarHandler : DollarHandlerBase
    {
        protected override int Value => 20;

        public TwentyDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }

    }

    public class TenDollarHandler : DollarHandlerBase
    {
        protected override int Value => 10;

        public TenDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }
    }

    public class FiveDollarHandler : DollarHandlerBase
    {
        protected override int Value => 5;

        public FiveDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }
    }

    public class TwoDollarHandler : DollarHandlerBase
    {
        protected override int Value => 2;

        public TwoDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }

    }

    public class OneDollarHandler : DollarHandlerBase
    {
        protected override int Value => 1;

        public OneDollarHandler(BanknoteHandler nextHandler) : base(nextHandler)
        { }

    }

    public class FiveThousandRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 5000;
        public FiveThousandRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class TwoThousandRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 2000;
        public TwoThousandRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class ThousandRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 1000;
        public ThousandRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class FiveHundredRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 500;
        public FiveHundredRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class TwoHundredRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 200;
        public TwoHundredRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class HundredRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 50;
        public HundredRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class FiftyRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 50;
        public FiftyRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }


    public class TenRubelesHandler : RubelesHandlerBase
    {
        protected override int Value => 10;
        public TenRubelesHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class FiveHundredEuroHandler : EuroHandlerBase
    {
        protected override int Value => 500;
        public FiveHundredEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class TwoHundredEuroHandler : EuroHandlerBase
    {
        protected override int Value => 200;
        public TwoHundredEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class HundredEuroHandler : EuroHandlerBase
    {
        protected override int Value => 100;
        public HundredEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class FiftyEuroHandler : EuroHandlerBase
    {
        protected override int Value => 50;
        public FiftyEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class TwentyEuroHandler : EuroHandlerBase
    {
        protected override int Value => 20;
        public TwentyEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class TenEuroHandler : EuroHandlerBase
    {
        protected override int Value => 10;
        public TenEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }

    public class FiveEuroHandler : EuroHandlerBase
    {
        protected override int Value => 5;
        public FiveEuroHandler(BanknoteHandler nextHandler) : base(nextHandler) { }
    }   
}


