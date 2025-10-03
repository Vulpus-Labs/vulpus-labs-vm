package com.vulpuslabs.crosstalk;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.crosstalk.*;
import com.vulpuslabs.vulpes.values.events.NotificationReceiver;
import com.vulpuslabs.vulpes.values.inputs.CvModulatableKnob;


//[/user-imports]


public class Crosstalk extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Crosstalk( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Crosstalk", ModuleType.ModuleType_PolyphonicUtilities, 1.0 );

      InitializeControls();


      canBeBypassed = true;
      SetSkin( "15b67c22266d4c678d86b6f108e15c34" );
   }

void InitializeControls()
{

      polyInput = new VoltagePolyJack( "polyInput", "Poly Input", this, JackType.JackType_PolyInput );
      AddComponent( polyInput );
      polyInput.SetWantsMouseNotifications( false );
      polyInput.SetPosition( 9, 21 );
      polyInput.SetSize( 25, 25 );
      polyInput.SetSkin( "Poly Jack Drab" );

      polyOutput = new VoltagePolyJack( "polyOutput", "Poly Output", this, JackType.JackType_PolyOutput );
      AddComponent( polyOutput );
      polyOutput.SetWantsMouseNotifications( false );
      polyOutput.SetPosition( 43, 316 );
      polyOutput.SetSize( 25, 25 );
      polyOutput.SetSkin( "Poly Jack Drab" );

      bleedAmountKnob = new VoltageKnob( "bleedAmountKnob", "Bleed Amount", this, 0.0, 1.0, 0.0 );
      AddComponent( bleedAmountKnob );
      bleedAmountKnob.SetWantsMouseNotifications( false );
      bleedAmountKnob.SetPosition( 11, 62 );
      bleedAmountKnob.SetSize( 50, 50 );
      bleedAmountKnob.SetSkin( "TR Large (white tick)" );
      bleedAmountKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
      bleedAmountKnob.SetKnobParams( 215, 145 );
      bleedAmountKnob.DisplayValueInPercent( true );
      bleedAmountKnob.SetKnobAdjustsRing( true );

      ringModAmountKnob = new VoltageKnob( "ringModAmountKnob", "Ring Modulation Amount", this, 0.0, 1.0, 0.0 );
      AddComponent( ringModAmountKnob );
      ringModAmountKnob.SetWantsMouseNotifications( false );
      ringModAmountKnob.SetPosition( 11, 142 );
      ringModAmountKnob.SetSize( 50, 50 );
      ringModAmountKnob.SetSkin( "TR Large (white tick)" );
      ringModAmountKnob.SetRange( 0.0, 1.0, 0.0, false, 0 );
      ringModAmountKnob.SetKnobParams( 215, 145 );
      ringModAmountKnob.DisplayValueInPercent( true );
      ringModAmountKnob.SetKnobAdjustsRing( true );

      filterCentreKnob = new VoltageKnob( "filterCentreKnob", "Filter Centre", this, 20.0, 20000, 5000 );
      AddComponent( filterCentreKnob );
      filterCentreKnob.SetWantsMouseNotifications( false );
      filterCentreKnob.SetPosition( 11, 222 );
      filterCentreKnob.SetSize( 50, 50 );
      filterCentreKnob.SetSkin( "TR Large (white tick)" );
      filterCentreKnob.SetRange( 20.0, 20000, 5000, false, 0 );
      filterCentreKnob.SetKnobParams( 215, 145 );
      filterCentreKnob.SetUnits( "Hz" );
      filterCentreKnob.DisplayValueInPercent( false );
      filterCentreKnob.SetKnobAdjustsRing( true );
      filterCentreKnob.SetMidpointValue( 5000 );

      bleedCvInput = new VoltageAudioJack( "bleedCvInput", "Bleed CV Input", this, JackType.JackType_AudioInput );
      AddComponent( bleedCvInput );
      bleedCvInput.SetWantsMouseNotifications( false );
      bleedCvInput.SetPosition( 4, 112 );
      bleedCvInput.SetSize( 25, 25 );
      bleedCvInput.SetSkin( "Mini Jack 25px" );

      bleedCvAmountKnob = new VoltageKnob( "bleedCvAmountKnob", "Bleed CV Amount", this, -1, 1.0, 0 );
      AddComponent( bleedCvAmountKnob );
      bleedCvAmountKnob.SetWantsMouseNotifications( false );
      bleedCvAmountKnob.SetPosition( 43, 114 );
      bleedCvAmountKnob.SetSize( 25, 25 );
      bleedCvAmountKnob.SetSkin( "Plastic Maroon" );
      bleedCvAmountKnob.SetRange( -1, 1.0, 0, false, 0 );
      bleedCvAmountKnob.SetKnobParams( 215, 145 );
      bleedCvAmountKnob.DisplayValueInPercent( false );
      bleedCvAmountKnob.SetKnobAdjustsRing( true );

      ringModCvAmountKnob = new VoltageKnob( "ringModCvAmountKnob", "Ring Modulation CV Amount", this, -1, 1.0, 0 );
      AddComponent( ringModCvAmountKnob );
      ringModCvAmountKnob.SetWantsMouseNotifications( false );
      ringModCvAmountKnob.SetPosition( 43, 193 );
      ringModCvAmountKnob.SetSize( 25, 25 );
      ringModCvAmountKnob.SetSkin( "Plastic Maroon" );
      ringModCvAmountKnob.SetRange( -1, 1.0, 0, false, 0 );
      ringModCvAmountKnob.SetKnobParams( 215, 145 );
      ringModCvAmountKnob.DisplayValueInPercent( false );
      ringModCvAmountKnob.SetKnobAdjustsRing( true );

      filterCentreCvAmountKnob = new VoltageKnob( "filterCentreCvAmountKnob", "Filter CV Amount", this, -1, 1.0, 0 );
      AddComponent( filterCentreCvAmountKnob );
      filterCentreCvAmountKnob.SetWantsMouseNotifications( false );
      filterCentreCvAmountKnob.SetPosition( 43, 273 );
      filterCentreCvAmountKnob.SetSize( 25, 25 );
      filterCentreCvAmountKnob.SetSkin( "Plastic Maroon" );
      filterCentreCvAmountKnob.SetRange( -1, 1.0, 0, false, 0 );
      filterCentreCvAmountKnob.SetKnobParams( 215, 145 );
      filterCentreCvAmountKnob.DisplayValueInPercent( false );
      filterCentreCvAmountKnob.SetKnobAdjustsRing( true );

      ringModCvInput = new VoltageAudioJack( "ringModCvInput", "Ring Modulation CV Input", this, JackType.JackType_AudioInput );
      AddComponent( ringModCvInput );
      ringModCvInput.SetWantsMouseNotifications( false );
      ringModCvInput.SetPosition( 4, 192 );
      ringModCvInput.SetSize( 25, 25 );
      ringModCvInput.SetSkin( "Mini Jack 25px" );

      filterCentreCvInput = new VoltageAudioJack( "filterCentreCvInput", "Filter Centre CV", this, JackType.JackType_AudioInput );
      AddComponent( filterCentreCvInput );
      filterCentreCvInput.SetWantsMouseNotifications( false );
      filterCentreCvInput.SetPosition( 4, 272 );
      filterCentreCvInput.SetSize( 25, 25 );
      filterCentreCvInput.SetSkin( "Mini Jack 25px" );

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "CROSSTALK" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 0, 0 );
      textLabel3.SetSize( 72, 20 );
      textLabel3.SetEditable( false, false );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel3.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel3.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel3.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel3.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel3.SetBorderSize( 1 );
      textLabel3.SetMultiLineEdit( false );
      textLabel3.SetIsNumberEditor( false );
      textLabel3.SetNumberEditorRange( 0, 100 );
      textLabel3.SetNumberEditorInterval( 1 );
      textLabel3.SetNumberEditorUsesMouseWheel( false );
      textLabel3.SetHasCustomTextHoverColor( false );
      textLabel3.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel3.SetFont( "Arial", 10, true, false );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "VULPUS LABS" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 0, 340 );
      textLabel4.SetSize( 72, 20 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel4.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel4.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel4.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel4.SetBorderSize( 1 );
      textLabel4.SetMultiLineEdit( false );
      textLabel4.SetIsNumberEditor( false );
      textLabel4.SetNumberEditorRange( 0, 100 );
      textLabel4.SetNumberEditorInterval( 1 );
      textLabel4.SetNumberEditorUsesMouseWheel( false );
      textLabel4.SetHasCustomTextHoverColor( false );
      textLabel4.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel4.SetFont( "Arial", 10, true, false );

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "IN" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 0, 42 );
      textLabel5.SetSize( 72, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel5.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel5.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel5.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel5.SetBorderSize( 1 );
      textLabel5.SetMultiLineEdit( false );
      textLabel5.SetIsNumberEditor( false );
      textLabel5.SetNumberEditorRange( 0, 100 );
      textLabel5.SetNumberEditorInterval( 1 );
      textLabel5.SetNumberEditorUsesMouseWheel( false );
      textLabel5.SetHasCustomTextHoverColor( false );
      textLabel5.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel5.SetFont( "Arial", 10, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "OUT" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 0, 306 );
      textLabel6.SetSize( 72, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel6.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel6.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel6.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel6.SetBorderSize( 1 );
      textLabel6.SetMultiLineEdit( false );
      textLabel6.SetIsNumberEditor( false );
      textLabel6.SetNumberEditorRange( 0, 100 );
      textLabel6.SetNumberEditorInterval( 1 );
      textLabel6.SetNumberEditorUsesMouseWheel( false );
      textLabel6.SetHasCustomTextHoverColor( false );
      textLabel6.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel6.SetFont( "Arial", 10, true, false );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "FILTER" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 0, 240 );
      textLabel7.SetSize( 72, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 127 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 9, true, false );

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "BLEED" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 0, 80 );
      textLabel8.SetSize( 72, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 127 ) );
      textLabel8.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel8.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel8.SetBorderSize( 1 );
      textLabel8.SetMultiLineEdit( false );
      textLabel8.SetIsNumberEditor( false );
      textLabel8.SetNumberEditorRange( 0, 100 );
      textLabel8.SetNumberEditorInterval( 1 );
      textLabel8.SetNumberEditorUsesMouseWheel( false );
      textLabel8.SetHasCustomTextHoverColor( false );
      textLabel8.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel8.SetFont( "Arial", 9, true, false );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "RING" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 0, 160 );
      textLabel9.SetSize( 72, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 127 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( false );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 9, true, false );

      mixKnob = new VoltageKnob( "mixKnob", "Dry / Wet Mix", this, 0, 1.0, 0.5 );
      AddComponent( mixKnob );
      mixKnob.SetWantsMouseNotifications( false );
      mixKnob.SetPosition( 4, 317 );
      mixKnob.SetSize( 25, 25 );
      mixKnob.SetSkin( "Plastic Maroon" );
      mixKnob.SetRange( 0, 1.0, 0.5, false, 0 );
      mixKnob.SetKnobParams( 215, 145 );
      mixKnob.SetUnits( "Wet" );
      mixKnob.DisplayValueInPercent( true );
      mixKnob.SetKnobAdjustsRing( true );

      noiseSwitch = new VoltageSwitch( "noiseSwitch", "Noise Switch", this, 0 );
      AddComponent( noiseSwitch );
      noiseSwitch.SetWantsMouseNotifications( false );
      noiseSwitch.SetPosition( 51, 20 );
      noiseSwitch.SetSize( 15, 27 );
      noiseSwitch.SetSkin( "2-State Slide Vertical" );
}



   //-------------------------------------------------------------------------------
   //  public void Initialize()

      //  Initialize will get called shortly after your module's constructor runs. You can use it to
      //  do any initialization that the auto-generated code doesn't handle.
   //-------------------------------------------------------------------------------
   @Override
   public void Initialize()
   {
      //[user-Initialize]   Add your own initialization code here
      inputBus = new InputBus(
         new CvModulatableKnob(
            bleedAmountKnob.GetMinValue(),
            bleedAmountKnob.GetMaxValue(),
            receiver.registerInput(bleedCvInput, bleedCvInput::GetValue),
            receiver.registerSmoothedKnob(bleedAmountKnob, bleedAmountKnob.GetValue()),
            receiver.registerSmoothedKnob(bleedCvAmountKnob, bleedCvAmountKnob.GetValue())),
         new CvModulatableKnob(
            ringModAmountKnob.GetMinValue(),
            ringModAmountKnob.GetMaxValue(),
            receiver.registerInput(ringModCvInput, ringModCvInput::GetValue),
            receiver.registerSmoothedKnob(ringModAmountKnob, ringModAmountKnob.GetValue()),
            receiver.registerSmoothedKnob(ringModCvAmountKnob, ringModCvAmountKnob.GetValue())),
         new CvModulatableKnob(
            filterCentreKnob.GetMinValue(),
            filterCentreKnob.GetMaxValue(),
            receiver.registerInput(filterCentreCvInput, filterCentreCvInput::GetValue),
            receiver.registerSmoothedKnob(filterCentreKnob, filterCentreKnob.GetValue()),
            receiver.registerSmoothedKnob(filterCentreCvAmountKnob, filterCentreCvAmountKnob.GetValue())),
         receiver.registerSmoothedKnob(mixKnob, mixKnob.GetValue()),
         polyInput::GetPolyValue);
      
      outputBus = new OutputBus(polyOutput::SetPolyValue);receiver.register(noiseSwitch, (double value) -> controller.setNoiseEnabled(value == 1.0));
      receiver.register(polyOutput, outputBus::setOutputIsConnected);
      
      controller = new Controller(
         inputBus,
         outputBus,
         GetNumberOfPolyVoices());
         
      receiver.register(noiseSwitch, (double value) -> controller.setNoiseEnabled(value == 1.0));
      //[/user-Initialize]
   }


   //-------------------------------------------------------------------------------
   //  public void Destroy()

      //  Destroy will get called just before your module gets deleted. You can use it to perform any
      //  cleanup that's not handled automatically by Java.
   //-------------------------------------------------------------------------------
   @Override
   public void Destroy()
   {
      super.Destroy();
      //[user-Destroy]   Add your own module-getting-deleted code here



      //[/user-Destroy]
   }


   //-------------------------------------------------------------------------------
   //  public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )

      //  Notify will get called when various events occur - control values changing, timers firing, etc.
   //-------------------------------------------------------------------------------
   @Override
   public boolean Notify( VoltageComponent component, ModuleNotifications notification, double doubleValue, long longValue, int x, int y, Object object )
   {
      //[user-Notify]   Add your own notification handling code between this line and the notify-close comment
      switch( notification )
      {
         case Knob_Changed:   // doubleValue is the new VoltageKnob value
         {
            return receiver.knobValueChanged(component, doubleValue);
         }
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
            return receiver.switchChanged(component, doubleValue);
         }
      
         case Jack_Connected:   // longValue is the new cable ID
         {
            return receiver.jackConnected(component);
         }
      
         case Jack_Disconnected:   // All cables have been disconnected from this jack
         {
            return receiver.jackDisconnected(component);
         }
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonDown:   // called when user left-clicks on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_LeftButtonUp:   // called when user releases left mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonDown:   // called when user releases right mouse button on an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
         }
         break;
      
         case Object_RightButtonUp:   // called when user right-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         case Object_LeftButtonDoubleClick: // called when user left-button double-clicks on an object that receives mouse notifications
         {
         }
         break;
      
         // Less common notifications:
      
         case Named_Timer:   // object contains a String with the name of the timer that has fired
         {
         }
         break;
      
         case Canvas_Painting:   // About to paint canvas.  object is a java.awt.Rectangle with painting boundaries
         {
         }
         break;
      
         case Canvas_Painted:   // Canvas painting is complete
         {
         }
         break;
      
         case Control_DragStart:    // A user has started dragging on a control that has been marked as draggable
         {
         }
         break;
      
         case Control_DragOn:       // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragOff:      // This control has been dragged over during a drag operation. object contains the dragged object
         {
         }
         break;
      
         case Control_DragEnd:      // A user has ended their drag on a control that has been marked as draggable
         {
         }
         break;
      
         case Label_Changed:        // The text of an editable text control has changed
         {
         }
         break;
      
         case SoundPlayback_Start:   // A sound has begun playback
         {
         }
         break;
      
         case SoundPlayback_End:     // A sound has ended playback
         {
         }
         break;
      
         case Scrollbar_Position:    // longValue is the new scrollbar position
         {
         }
         break;
      
         case PolyVoices_Changed:    // longValue is the new number of poly voices
         {
            controller.setChannelCount((int) longValue);
         }
         break;
      
         case File_Dropped:     // 'object' is a String containing the file path
         {
         }
         break;
      
         case Preset_Loading_Start:   // called when preset loading begins
         {
         }
         break;
      
         case Preset_Loading_Finish:  // called when preset loading finishes
         {
         }
         break;
      
         case Variation_Loading_Start:    // sent when a variation is about to load
         {
         }
         break;
      
         case Variation_Loading_Finish:   // sent when a variation has just finished loading
         {
         }
         break;
      
         case Tempo_Changed:     // doubleValue is the new tempo
         {
         }
         break;
      
         case Randomized:     // called when the module's controls get randomized
         {
         }
         break;
      
         case VariationListChanged:   // sent when a variation gets added, deleted, or renamed, or the variations list gets reordered
         {
         }
         break;
      
         case Key_Press:     // sent when module has keyboard focus and a key is pressed; object is a VoltageKeyPressInfo object
         {
         }
         break;
      
         case Reset:    // sent when the module has been reset to default settings
         {
         }
         break;
      
         case Keyboard_NoteOn:   // sent when a note has been pressed on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Keyboard_NoteOff:   // sent when a note has been released on a VoltageKeyboard object. longValue is the note value ( 0-127 )
         {
         }
         break;
      
         case Curve_Changed:   // sent when user has edited a curve's value. 'object' will be a VoltageCurve.CurveChangeNotification object.
         {
         }
         break;
      }



      return false;
      //[/user-Notify]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessSample()

      //  ProcessSample is called once per sample. Usually it's where you read
      //  from input jacks, process audio, and write it to your output jacks.
      //  Since ProcesssSample gets called 48,000 times per second, offload CPU-intensive operations
      //  to other threads when possible and avoid calling native functions.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessSample()
   {
      //[user-ProcessSample]   Add your own process-sampling code here
      controller.processSample();


      //[/user-ProcessSample]
   }


   //-------------------------------------------------------------------------------
   //  public void ProcessBypassedSample()

      //  ProcessBypassedSample gets called instead of ProcessSample when you've checked the "Can Be Bypassed" box
      //  and a user has bypassed your module. If your module processes data from input jacks and then sends it to
      //  output jack(s), make ProcessBypassedSample just send the data from the input jacks to the output jacks without
      //  processing it.
   //-------------------------------------------------------------------------------
   @Override
   public void ProcessBypassedSample()
   {
      //[user-ProcessBypassedSample]   Add your own code here
      controller.processBypassedSample();


      //[/user-ProcessBypassedSample]
   }


   //-------------------------------------------------------------------------------
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here



      return super.GetTooltipText( component );
      //[/user-GetTooltipText]
   }


   //-------------------------------------------------------------------------------
   //  public void EditComponentValue( VoltageComponent component, double newValue, String newText )

      //  Gets called after a user clicks on a tooltip and types in a new value for a control. Override this if
      //  you've changed the default tooltip display (translating a linear value to logarithmic, for instance)
      //  in GetTooltipText().
   //-------------------------------------------------------------------------------
   @Override
   public void EditComponentValue( VoltageComponent component, double newValue, String newText )
   {
      //[user-EditComponentValue]   Add your own code here



      //[/user-EditComponentValue]
      super.EditComponentValue( component, newValue, newText );
   }


   //-------------------------------------------------------------------------------
   //  public void OnUndoRedo( String undoType, double newValue, Object optionalObject )

      //  If you've created custom undo events via calls to CreateUndoEvent, you'll need to
      //  process them in this function when they get triggered by undo/redo actions.
   //-------------------------------------------------------------------------------
   @Override
   public void OnUndoRedo( String undoType, double newValue, Object optionalObject )
   {
      //[user-OnUndoRedo]   Add your own code here



      //[/user-OnUndoRedo]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformation()

      //  Gets called when the module's state gets saved, typically when the user saves a preset with
      //  this module in it. Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformation()
   {
      //[user-GetStateInformation]   Add your own code here



      return null;
      //[/user-GetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformation(byte[] stateInfo)

      //  Gets called when this module's state is getting restored, typically when a user opens a preset with
      //  this module in it. The stateInfo parameter will contain whatever custom data you stored in GetStateInformation().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformation(byte[] stateInfo)
   {
      //[user-SetStateInformation]   Add your own code here



      //[/user-SetStateInformation]
   }


   //-------------------------------------------------------------------------------
   //  public byte[] GetStateInformationForVariations()

      //  Gets called when a user saves a variation with this module in it.
      //  Voltage Modular will automatically save the states of knobs, sliders, etc.,
      //  but if you have any custom state information you need to save, return it from this function.
   //-------------------------------------------------------------------------------
   @Override
   public byte[] GetStateInformationForVariations()
   {
      //[user-GetStateInformationForVariations]   Add your own code here



      return GetStateInformation();
      //[/user-GetStateInformationForVariations]
   }


   //-------------------------------------------------------------------------------
   //  public void SetStateInformationForVariations(byte[] stateInfo)

      //  Gets called when a user loads a variation with this module in it.
      //  The stateInfo parameter will contain whatever custom data you stored in GetStateInformationForVariations().
   //-------------------------------------------------------------------------------
   @Override
   public void SetStateInformationForVariations(byte[] stateInfo)
   {
      //[user-SetStateInformationForVariations]   Add your own code here
      SetStateInformation(stateInfo);



      //[/user-SetStateInformationForVariations]
   }


   // Auto-generated variables
   private VoltageSwitch noiseSwitch;
   private VoltageKnob mixKnob;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageAudioJack filterCentreCvInput;
   private VoltageAudioJack ringModCvInput;
   private VoltageKnob filterCentreCvAmountKnob;
   private VoltageKnob ringModCvAmountKnob;
   private VoltageKnob bleedCvAmountKnob;
   private VoltageAudioJack bleedCvInput;
   private VoltageKnob filterCentreKnob;
   private VoltageKnob ringModAmountKnob;
   private VoltageKnob bleedAmountKnob;
   private VoltagePolyJack polyOutput;
   private VoltagePolyJack polyInput;


   //[user-code-and-variables]    Add your own variables and functions here
private InputBus inputBus;
private OutputBus outputBus;
private Controller controller;
private final NotificationReceiver receiver = new NotificationReceiver();




   //[/user-code-and-variables]
}

 