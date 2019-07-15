package cashregister;


import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {

        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);
        //when
        Purchase purchase = new Purchase(new Item[]{});
        cashRegister.process(purchase);

        //then
        verify(printer, times(1)).print("");
        verify(printer, never()).print("Hello");
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
        Printer printer = mock(Printer.class);
        CashRegister cashRegister = new CashRegister(printer);

        //when
        Purchase purchase = mock(Purchase.class);
        when(purchase.asString()).thenReturn("Hello");
        cashRegister.process(purchase);

        //then
        verify(printer, never()).print("");
        verify(printer, times(1)).print("Hello");
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
        Printer printer = mock(Printer.class);
        Purchase purchase = mock(Purchase.class);
        CashRegister cashRegister = new CashRegister(printer);
        //when
        cashRegister.process(purchase);

        //then
        verify(printer, times(1)).print(purchase.asString());
    }

}
