package com.vulpuslabs.rkw2;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.modules.rkw2.*;


//[/user-imports]


public class RKW2 extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

@SuppressWarnings("this-escape") 
public RKW2( long moduleID, VoltageObjects voltageObjects )
{
   super( moduleID, voltageObjects, "RKW-2", ModuleType.ModuleType_Oscillators, 0.8 );

   InitializeControls();


   canBeBypassed = false;
   SetSkin( "b6b3e3abe2204d77b6c964526e2217ad" );
}

void InitializeControls()
{

   audioOut = new VoltageAudioJack( "audioOut", "Audio Ou", this, JackType.JackType_AudioOutput );
   AddComponent( audioOut );
   audioOut.SetWantsMouseNotifications( false );
   audioOut.SetPosition( 26, 265 );
   audioOut.SetSize( 25, 25 );
   audioOut.SetSkin( "Jack Round White Ring" );

   outputModeSwitch = new VoltageSwitch( "outputModeSwitch", "Output Mode", this, 0 );
   AddComponent( outputModeSwitch );
   outputModeSwitch.SetWantsMouseNotifications( false );
   outputModeSwitch.SetPosition( 9, 267 );
   outputModeSwitch.SetSize( 12, 21 );
   outputModeSwitch.SetSkin( "2-State Slide Black" );

   textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "RKW-2" );
   AddComponent( textLabel1 );
   textLabel1.SetWantsMouseNotifications( false );
   textLabel1.SetPosition( 0, 0 );
   textLabel1.SetSize( 57, 15 );
   textLabel1.SetEditable( false, false );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel1.SetBorderSize( 1 );
   textLabel1.SetMultiLineEdit( true );
   textLabel1.SetIsNumberEditor( false );
   textLabel1.SetNumberEditorRange( 0, 100 );
   textLabel1.SetNumberEditorInterval( 1 );
   textLabel1.SetNumberEditorUsesMouseWheel( false );
   textLabel1.SetHasCustomTextHoverColor( false );
   textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel1.SetFont( "Arial Black", 10, false, false );

   textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "VULPUS LABS" );
   AddComponent( textLabel2 );
   textLabel2.SetWantsMouseNotifications( false );
   textLabel2.SetPosition( 6, 328 );
   textLabel2.SetSize( 46, 32 );
   textLabel2.SetEditable( false, false );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel2.SetBorderSize( 1 );
   textLabel2.SetMultiLineEdit( true );
   textLabel2.SetIsNumberEditor( false );
   textLabel2.SetNumberEditorRange( 0, 100 );
   textLabel2.SetNumberEditorInterval( 1 );
   textLabel2.SetNumberEditorUsesMouseWheel( false );
   textLabel2.SetHasCustomTextHoverColor( false );
   textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel2.SetFont( "Arial Black", 10, false, false );

   textLabel22 = new VoltageLabel( "textLabel22", "textLabel22", this, "BP" );
   AddComponent( textLabel22 );
   textLabel22.SetWantsMouseNotifications( false );
   textLabel22.SetPosition( 8, 291 );
   textLabel22.SetSize( 15, 14 );
   textLabel22.SetEditable( false, false );
   textLabel22.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel22.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel22.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel22.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel22.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel22.SetBorderSize( 1 );
   textLabel22.SetMultiLineEdit( false );
   textLabel22.SetIsNumberEditor( false );
   textLabel22.SetNumberEditorRange( 0, 100 );
   textLabel22.SetNumberEditorInterval( 1 );
   textLabel22.SetNumberEditorUsesMouseWheel( false );
   textLabel22.SetHasCustomTextHoverColor( false );
   textLabel22.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel22.SetFont( "Arial Black", 10, false, false );

   textLabel23 = new VoltageLabel( "textLabel23", "textLabel23", this, "TV" );
   AddComponent( textLabel23 );
   textLabel23.SetWantsMouseNotifications( false );
   textLabel23.SetPosition( 9, 249 );
   textLabel23.SetSize( 13, 14 );
   textLabel23.SetEditable( false, false );
   textLabel23.SetJustificationFlags( VoltageLabel.Justification.Right );
   textLabel23.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel23.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel23.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel23.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel23.SetBorderSize( 1 );
   textLabel23.SetMultiLineEdit( false );
   textLabel23.SetIsNumberEditor( false );
   textLabel23.SetNumberEditorRange( 0, 100 );
   textLabel23.SetNumberEditorInterval( 1 );
   textLabel23.SetNumberEditorUsesMouseWheel( false );
   textLabel23.SetHasCustomTextHoverColor( false );
   textLabel23.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel23.SetFont( "Arial Black", 10, false, false );

   textLabel21 = new VoltageLabel( "textLabel21", "textLabel21", this, "OUTPUT" );
   AddComponent( textLabel21 );
   textLabel21.SetWantsMouseNotifications( false );
   textLabel21.SetPosition( 0, 310 );
   textLabel21.SetSize( 57, 15 );
   textLabel21.SetEditable( false, false );
   textLabel21.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel21.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel21.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel21.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel21.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel21.SetBorderSize( 1 );
   textLabel21.SetMultiLineEdit( false );
   textLabel21.SetIsNumberEditor( false );
   textLabel21.SetNumberEditorRange( 0, 100 );
   textLabel21.SetNumberEditorInterval( 1 );
   textLabel21.SetNumberEditorUsesMouseWheel( false );
   textLabel21.SetHasCustomTextHoverColor( false );
   textLabel21.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel21.SetFont( "Arial Black", 10, false, false );

   voctIn = new VoltagePolyJack( "voctin", "V/OCT in", this, JackType.JackType_PolyInput );
   AddComponent( voctIn );
   voctIn.SetWantsMouseNotifications( false );
   voctIn.SetPosition( 17, 31 );
   voctIn.SetSize( 25, 25 );
   voctIn.SetSkin( "Poly Jack Straight" );

   velocityIn = new VoltagePolyJack( "velocityIn", "Velocity In", this, JackType.JackType_PolyInput );
   AddComponent( velocityIn );
   velocityIn.SetWantsMouseNotifications( false );
   velocityIn.SetPosition( 17, 81 );
   velocityIn.SetSize( 25, 25 );
   velocityIn.SetSkin( "Poly Jack Straight" );

   textLabel24 = new VoltageLabel( "textLabel24", "textLabel24", this, "V/OCT" );
   AddComponent( textLabel24 );
   textLabel24.SetWantsMouseNotifications( false );
   textLabel24.SetPosition( 0, 61 );
   textLabel24.SetSize( 57, 15 );
   textLabel24.SetEditable( false, false );
   textLabel24.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel24.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel24.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel24.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel24.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel24.SetBorderSize( 1 );
   textLabel24.SetMultiLineEdit( false );
   textLabel24.SetIsNumberEditor( false );
   textLabel24.SetNumberEditorRange( 0, 100 );
   textLabel24.SetNumberEditorInterval( 1 );
   textLabel24.SetNumberEditorUsesMouseWheel( false );
   textLabel24.SetHasCustomTextHoverColor( false );
   textLabel24.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel24.SetFont( "Arial Black", 10, false, false );

   textLabel25 = new VoltageLabel( "textLabel25", "textLabel25", this, "VELOCITY" );
   AddComponent( textLabel25 );
   textLabel25.SetWantsMouseNotifications( false );
   textLabel25.SetPosition( 0, 111 );
   textLabel25.SetSize( 57, 15 );
   textLabel25.SetEditable( false, false );
   textLabel25.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel25.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel25.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel25.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel25.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel25.SetBorderSize( 1 );
   textLabel25.SetMultiLineEdit( false );
   textLabel25.SetIsNumberEditor( false );
   textLabel25.SetNumberEditorRange( 0, 100 );
   textLabel25.SetNumberEditorInterval( 1 );
   textLabel25.SetNumberEditorUsesMouseWheel( false );
   textLabel25.SetHasCustomTextHoverColor( false );
   textLabel25.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel25.SetFont( "Arial Black", 10, false, false );

   textLabel26 = new VoltageLabel( "textLabel26", "textLabel26", this, "JITTER" );
   AddComponent( textLabel26 );
   textLabel26.SetWantsMouseNotifications( false );
   textLabel26.SetPosition( 0, 166 );
   textLabel26.SetSize( 57, 15 );
   textLabel26.SetEditable( false, false );
   textLabel26.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel26.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel26.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel26.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel26.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel26.SetBorderSize( 1 );
   textLabel26.SetMultiLineEdit( false );
   textLabel26.SetIsNumberEditor( false );
   textLabel26.SetNumberEditorRange( 0, 100 );
   textLabel26.SetNumberEditorInterval( 1 );
   textLabel26.SetNumberEditorUsesMouseWheel( false );
   textLabel26.SetHasCustomTextHoverColor( false );
   textLabel26.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel26.SetFont( "Arial Black", 10, false, false );

   textLabel27 = new VoltageLabel( "textLabel27", "textLabel27", this, "PULSE SIZE" );
   AddComponent( textLabel27 );
   textLabel27.SetWantsMouseNotifications( false );
   textLabel27.SetPosition( 0, 221 );
   textLabel27.SetSize( 57, 15 );
   textLabel27.SetEditable( false, false );
   textLabel27.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
   textLabel27.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
   textLabel27.SetColor( new Color( 255, 255, 255, 255 ) );
   textLabel27.SetBkColor( new Color( 65, 65, 65, 0 ) );
   textLabel27.SetBorderColor( new Color( 0, 0, 0, 0 ) );
   textLabel27.SetBorderSize( 1 );
   textLabel27.SetMultiLineEdit( false );
   textLabel27.SetIsNumberEditor( false );
   textLabel27.SetNumberEditorRange( 0, 100 );
   textLabel27.SetNumberEditorInterval( 1 );
   textLabel27.SetNumberEditorUsesMouseWheel( false );
   textLabel27.SetHasCustomTextHoverColor( false );
   textLabel27.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
   textLabel27.SetFont( "Arial Black", 10, false, false );

   pulseSizeKnob = new VoltageKnob( "pulseSizeKnob", "Pulse Size", this, 4, 32, 18.00 );
   AddComponent( pulseSizeKnob );
   pulseSizeKnob.SetWantsMouseNotifications( false );
   pulseSizeKnob.SetPosition( 17, 191 );
   pulseSizeKnob.SetSize( 27, 27 );
   pulseSizeKnob.SetSkin( "Plastic Red" );
   pulseSizeKnob.SetRange( 4, 32, 18.00, false, 29 );
   pulseSizeKnob.SetKnobParams( 215, 145 );
   pulseSizeKnob.DisplayValueInPercent( false );
   pulseSizeKnob.SetKnobAdjustsRing( true );

   jitterKnob = new VoltageKnob( "jitterKnob", "Jitter", this, 0.0, 1.0, 0 );
   AddComponent( jitterKnob );
   jitterKnob.SetWantsMouseNotifications( false );
   jitterKnob.SetPosition( 17, 136 );
   jitterKnob.SetSize( 27, 27 );
   jitterKnob.SetSkin( "Plastic Yellow" );
   jitterKnob.SetRange( 0.0, 1.0, 0, false, 0 );
   jitterKnob.SetKnobParams( 215, 145 );
   jitterKnob.DisplayValueInPercent( false );
   jitterKnob.SetKnobAdjustsRing( true );
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
   voices = GetNumberOfPolyVoices();


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
         if (component == jitterKnob) {
            engine.setJitter(doubleValue);
         }
         if (component == pulseSizeKnob) {
            engine.setPulseSize((int) doubleValue);
         }
      }
      break;
   
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
         if (component == outputModeSwitch) {
            engine.setFilterProfile(doubleValue == 0.0
               ? FilterProfile.PIEZO
               : FilterProfile.TV_SPEAKER);
         }
      }
      break;
   
      case Jack_Connected:   // longValue is the new cable ID
      {
      }
      break;
   
      case Jack_Disconnected:   // All cables have been disconnected from this jack
      {
      }
      break;
   
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
         voices = (int) longValue;
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
   for (int i=0; i<voices; i++) {
     engine.updateChannel(
        i,
        voctIn.GetPolyValue(i),
        velocityIn.GetPolyValue(i)
     );
  }
      
   audioOut.SetValue(engine.processSample());
   //[/user-ProcessSample]
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
   if (component == outputModeSwitch) {
      return outputModeSwitch.GetValue() == 0
         ? "Beeper"
         : "TV Speaker";
   }      
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
private VoltageKnob jitterKnob;
private VoltageKnob pulseSizeKnob;
private VoltageLabel textLabel27;
private VoltageLabel textLabel26;
private VoltageLabel textLabel25;
private VoltageLabel textLabel24;
private VoltagePolyJack velocityIn;
private VoltagePolyJack voctIn;
private VoltageLabel textLabel21;
private VoltageLabel textLabel23;
private VoltageLabel textLabel22;
private VoltageLabel textLabel2;
private VoltageLabel textLabel1;
private VoltageSwitch outputModeSwitch;
private VoltageAudioJack audioOut;


//[user-code-and-variables]    Add your own variables and functions here
private final SoundEngine engine = new SoundEngine(48000);
private int voices = 16;



//[/user-code-and-variables]
}

 