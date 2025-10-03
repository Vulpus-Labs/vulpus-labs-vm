package com.vulpuslabs.glowup;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.libs.maths.*;
import com.vulpuslabs.libs.fft.*;
import java.util.concurrent.ExecutorService;  
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Random;   


//[/user-imports]


public class GlowUp extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   @SuppressWarnings("this-escape") 
   public GlowUp( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "GlowUp", ModuleType.ModuleType_Effect, 0.6 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "6c04f1b310434bce897aaf34958d852b" );
   }

void InitializeControls()
{

      inputJack = new VoltageAudioJack( "inputJack", "Input", this, JackType.JackType_AudioInput );
      AddComponent( inputJack );
      inputJack.SetWantsMouseNotifications( false );
      inputJack.SetPosition( 9, 18 );
      inputJack.SetSize( 25, 25 );
      inputJack.SetSkin( "Jack Round Sky Ring" );

      outputJack = new VoltageAudioJack( "outputJack", "Output", this, JackType.JackType_AudioOutput );
      AddComponent( outputJack );
      outputJack.SetWantsMouseNotifications( false );
      outputJack.SetPosition( 9, 287 );
      outputJack.SetSize( 25, 25 );
      outputJack.SetSkin( "Jack Round Teal Ring" );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "GLOW UP" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 0, 0 );
      textLabel1.SetSize( 43, 15 );
      textLabel1.SetEditable( false, false );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel1.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel1.SetBorderSize( 1 );
      textLabel1.SetMultiLineEdit( false );
      textLabel1.SetIsNumberEditor( false );
      textLabel1.SetNumberEditorRange( 0, 100 );
      textLabel1.SetNumberEditorInterval( 1 );
      textLabel1.SetNumberEditorUsesMouseWheel( false );
      textLabel1.SetHasCustomTextHoverColor( false );
      textLabel1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel1.SetFont( "Arial", 10, true, false );

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "IN" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 0, 48 );
      textLabel2.SetSize( 43, 15 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel2.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel2.SetBorderSize( 1 );
      textLabel2.SetMultiLineEdit( false );
      textLabel2.SetIsNumberEditor( false );
      textLabel2.SetNumberEditorRange( 0, 100 );
      textLabel2.SetNumberEditorInterval( 1 );
      textLabel2.SetNumberEditorUsesMouseWheel( false );
      textLabel2.SetHasCustomTextHoverColor( false );
      textLabel2.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel2.SetFont( "Arial", 10, true, false );

      outLabel = new VoltageLabel( "outLabel", "textLabel4", this, "OUT" );
      AddComponent( outLabel );
      outLabel.SetWantsMouseNotifications( false );
      outLabel.SetPosition( 0, 318 );
      outLabel.SetSize( 43, 15 );
      outLabel.SetEditable( false, false );
      outLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      outLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      outLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      outLabel.SetBkColor( new Color( 65, 65, 65, 255 ) );
      outLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      outLabel.SetBorderSize( 1 );
      outLabel.SetMultiLineEdit( false );
      outLabel.SetIsNumberEditor( false );
      outLabel.SetNumberEditorRange( 0, 100 );
      outLabel.SetNumberEditorInterval( 1 );
      outLabel.SetNumberEditorUsesMouseWheel( false );
      outLabel.SetHasCustomTextHoverColor( false );
      outLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      outLabel.SetFont( "Arial", 10, true, false );

      vulpusLabsLabel = new VoltageLabel( "vulpusLabsLabel", "Vulpus Labs", this, "VULPUS LABS" );
      AddComponent( vulpusLabsLabel );
      vulpusLabsLabel.SetWantsMouseNotifications( false );
      vulpusLabsLabel.SetPosition( 0, 335 );
      vulpusLabsLabel.SetSize( 43, 25 );
      vulpusLabsLabel.SetEditable( false, false );
      vulpusLabsLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      vulpusLabsLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      vulpusLabsLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      vulpusLabsLabel.SetBkColor( new Color( 65, 65, 65, 0 ) );
      vulpusLabsLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      vulpusLabsLabel.SetBorderSize( 1 );
      vulpusLabsLabel.SetMultiLineEdit( true );
      vulpusLabsLabel.SetIsNumberEditor( false );
      vulpusLabsLabel.SetNumberEditorRange( 0, 100 );
      vulpusLabsLabel.SetNumberEditorInterval( 1 );
      vulpusLabsLabel.SetNumberEditorUsesMouseWheel( false );
      vulpusLabsLabel.SetHasCustomTextHoverColor( false );
      vulpusLabsLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      vulpusLabsLabel.SetFont( "Arial", 10, true, false );

      firstHarmonicKnob = new VoltageKnob( "firstHarmonicKnob", "Octave Up", this, 0, 1, 0.2 );
      AddComponent( firstHarmonicKnob );
      firstHarmonicKnob.SetWantsMouseNotifications( false );
      firstHarmonicKnob.SetPosition( 9, 120 );
      firstHarmonicKnob.SetSize( 27, 27 );
      firstHarmonicKnob.SetSkin( "Plastic Maroon" );
      firstHarmonicKnob.SetRange( 0, 1, 0.2, false, 0 );
      firstHarmonicKnob.SetKnobParams( 215, 145 );
      firstHarmonicKnob.DisplayValueInPercent( true );
      firstHarmonicKnob.SetKnobAdjustsRing( true );

      secondHarmonicKnob = new VoltageKnob( "secondHarmonicKnob", "Octave +5 Up", this, 0, 1, 0.2 );
      AddComponent( secondHarmonicKnob );
      secondHarmonicKnob.SetWantsMouseNotifications( false );
      secondHarmonicKnob.SetPosition( 9, 174 );
      secondHarmonicKnob.SetSize( 27, 27 );
      secondHarmonicKnob.SetSkin( "Plastic Cherry" );
      secondHarmonicKnob.SetRange( 0, 1, 0.2, false, 0 );
      secondHarmonicKnob.SetKnobParams( 215, 145 );
      secondHarmonicKnob.DisplayValueInPercent( true );
      secondHarmonicKnob.SetKnobAdjustsRing( true );

      thirdHarmonicKnob = new VoltageKnob( "thirdHarmonicKnob", "Two Octaves Up", this, 0, 1, 0.2 );
      AddComponent( thirdHarmonicKnob );
      thirdHarmonicKnob.SetWantsMouseNotifications( false );
      thirdHarmonicKnob.SetPosition( 9, 228 );
      thirdHarmonicKnob.SetSize( 27, 27 );
      thirdHarmonicKnob.SetSkin( "Plastic Orange" );
      thirdHarmonicKnob.SetRange( 0, 1, 0.2, false, 0 );
      thirdHarmonicKnob.SetKnobParams( 215, 145 );
      thirdHarmonicKnob.DisplayValueInPercent( true );
      thirdHarmonicKnob.SetKnobAdjustsRing( true );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "+12" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 0, 152 );
      textLabel10.SetSize( 43, 15 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 96, 0, 0, 255 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "+24" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 0, 260 );
      textLabel12.SetSize( 43, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 160, 48, 0, 255 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( false );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "+19" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 0, 206 );
      textLabel11.SetSize( 43, 16 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 128, 0, 0, 255 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 10, true, false );

      overflowWarningLED = new VoltageLED( "overflowWarningLED", "Overflow Warning", this );
      AddComponent( overflowWarningLED );
      overflowWarningLED.SetWantsMouseNotifications( true );
      overflowWarningLED.SetPosition( 32, 278 );
      overflowWarningLED.SetSize( 11, 11 );
      overflowWarningLED.SetSkin( "Red" );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "QUALITY" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 0, 98 );
      textLabel7.SetSize( 43, 18 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel7.SetBkColor( new Color( 65, 65, 65, 255 ) );
      textLabel7.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel7.SetBorderSize( 1 );
      textLabel7.SetMultiLineEdit( false );
      textLabel7.SetIsNumberEditor( false );
      textLabel7.SetNumberEditorRange( 0, 100 );
      textLabel7.SetNumberEditorInterval( 1 );
      textLabel7.SetNumberEditorUsesMouseWheel( false );
      textLabel7.SetHasCustomTextHoverColor( false );
      textLabel7.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel7.SetFont( "Arial", 10, true, false );

      qualitySwitch = new VoltageSwitch( "qualitySwitch", "Quality", this, 1 );
      AddComponent( qualitySwitch );
      qualitySwitch.SetWantsMouseNotifications( false );
      qualitySwitch.SetPosition( 5, 64 );
      qualitySwitch.SetSize( 35, 35 );
      qualitySwitch.SetSkin( "3-State Silver Horizontal" );

      drySignalCutToggle = new VoltageToggle( "drySignalCutToggle", "Dry Signal Cut", this, false, 0 );
      AddComponent( drySignalCutToggle );
      drySignalCutToggle.SetWantsMouseNotifications( false );
      drySignalCutToggle.SetPosition( 1, 276 );
      drySignalCutToggle.SetSize( 12, 12 );
      drySignalCutToggle.SetSkin( "Small Square Red" );
      drySignalCutToggle.ShowOverlay( false );
      drySignalCutToggle.SetOverlayText( "" );
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
      initialiseBuffers();
      StartGuiUpdateTimer();
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
      processor.stop();
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
            if (component == firstHarmonicKnob) {
               transformer.setFirstHarmonic(doubleValue);
            } else if (component == secondHarmonicKnob) {
               transformer.setSecondHarmonic(doubleValue);
            } else if (component == thirdHarmonicKnob) {
               transformer.setThirdHarmonic(doubleValue);
            }
         }
         break;
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
            transformer.setSubtractOriginal(doubleValue == 1.0);
         }
         break;
      
         case Switch_Changed:   // doubleValue is the new switch value
         {
            var newWindowSizePower = (int) doubleValue;
            if (newWindowSizePower != windowSizePower) {
               windowSizePower = newWindowSizePower;
               initialiseBuffers();
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
            var isOverflow = processor.checkOverflowWarning();
            overflowWarningLED.SetValue(isOverflow ? 1.0 : 0.0);
         }
         break;
      
         case Object_MouseMove:   // called when mouse is over an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
            if (component == overflowWarningLED) {
               SetMouseCursor(MouseCursorTypes.PointingHand);
            }
         }
         break;
      
         case Object_MouseLeave:  // called when mouse leaves an object that receives mouse notifications. 'object' parameter is a VoltageMouseKeyFlags object.
         {
            if (component == overflowWarningLED) {
               SetMouseCursor(MouseCursorTypes.Normal);
            }
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
            if (component == overflowWarningLED) {
               int menuSelected = ShowDropDownMenu(new String[] {
                  "Read Buffer Offset",
                  "{sep}",
                  "128 samples",
                  "256 samples",
                  "384 samples",
                  "512 samples",
                  "640 samples",
                  "768 samples",
                  "892 samples",
                  "1024 samples"},
                  minReadOffsetMultiple + 1,
                  overflowWarningLED);
               if (menuSelected > 1) {
                  minReadOffsetMultiple = menuSelected - 1;
                  initialiseBuffers();
               }
            }
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
      outputJack.SetValue(
         5.0 * Approximate.tanh(
            0.2 * processor.processSample(inputJack.GetValue())
         )
      );
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
      if (component == qualitySwitch) {
         var value = qualitySwitch.GetValue();
         if (value == 0) {
            return "Low";
         } else if (value == 1) {
            return "Medium";
         } else {
            return "High";
         }
      }
      
      if (component == overflowWarningLED) {
         return "Output latency " + processor.getOutputLatency() + " samples";
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
      return new byte[] { (byte) minReadOffsetMultiple };
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
      minReadOffsetMultiple = (int) stateInfo[0];
      initialiseBuffers();


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
   private VoltageToggle drySignalCutToggle;
   private VoltageSwitch qualitySwitch;
   private VoltageLabel textLabel7;
   private VoltageLED overflowWarningLED;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel10;
   private VoltageKnob thirdHarmonicKnob;
   private VoltageKnob secondHarmonicKnob;
   private VoltageKnob firstHarmonicKnob;
   private VoltageLabel vulpusLabsLabel;
   private VoltageLabel outLabel;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageAudioJack outputJack;
   private VoltageAudioJack inputJack;


   //[user-code-and-variables]    Add your own variables and functions here
private volatile FFTProcessor processor;
private DelayTransformer transformer;

private int windowSize;
private int windowSizePower;
private int minReadOffsetMultiple = 1;

private void initialiseBuffers() {
   if (processor != null) processor.stop();
   
   windowSize = 512 << windowSizePower;
   int binSize = windowSize << 1;
   int minReadOffset = 128 * minReadOffsetMultiple;
   
   DelayTransformer newTransformer = new DelayTransformer(windowSize);
   if (transformer != null) newTransformer.copyConfigurationFrom(transformer);
   transformer = newTransformer;
   
   processor = new FFTProcessor(windowSize, 4096, minReadOffset, transformer);
   processor.start();
}

private static final class DelayTransformer implements FFTTransformer {

   private double firstHarmonicAmount = 0.0;
   private double secondHarmonicAmount = 0.0;
   private double thirdHarmonicAmount = 0.0;
   private double initialBoost;
   
   private final double[] magSquared;
   private final double windowSizeReciprocal;
   private static final double ONE_THIRD = 2.0 / 3.0;
   
   public DelayTransformer(int windowSize) {
      this.magSquared = new double[windowSize];
      windowSizeReciprocal = 1.0 / windowSize;
   }
   
   public void setSubtractOriginal(boolean subtractOriginal) {
      this.initialBoost = subtractOriginal ? 0.0 : 1.0;
   }

   public void setFirstHarmonic(double firstHarmonicAmount ) {
      this.firstHarmonicAmount = firstHarmonicAmount * 16.0;
   }
   
   public void setSecondHarmonic(double secondHarmonicAmount ) {
      this.secondHarmonicAmount = secondHarmonicAmount * 16.0;
   }
   
   public void setThirdHarmonic(double thirdHarmonicAmount ) {
      this.thirdHarmonicAmount = thirdHarmonicAmount * 16.0;
   }
   
   public void copyConfigurationFrom(DelayTransformer other) {
      this.firstHarmonicAmount = other.firstHarmonicAmount;
      this.secondHarmonicAmount = other.secondHarmonicAmount;
      this.thirdHarmonicAmount = other.thirdHarmonicAmount;
      this.initialBoost = other.initialBoost;
   }
   
   @Override
   public void transform(double[][] fftBins) {
      int binSize = fftBins.length;
      
      double total = 0.0;
      double max = 0.0;
      for (int i=1; i<magSquared.length; i++) {
        var real = fftBins[i][0];
        var imag = fftBins[i][1];
        var mag = (real * real) + (imag * imag);
        mag = (0.3 * mag) + (0.7 * magSquared[i]);
        total += mag;
        max = Math.max(max, mag);
        magSquared[i] = mag;
      }
      double mean = total * windowSizeReciprocal;
      double maxVariance = max - mean;
      if (maxVariance == 0.0) return;
      
      double maxVarianceReciprocal = 1.0 / maxVariance;
      
      for (int i=1; i<magSquared.length; i++) {
         magSquared[i] = Math.max(0.0, (magSquared[i] - mean) * maxVarianceReciprocal);
      }
      
      int lowPtr = 4;
      int highPtr = binSize - 4;
            
      while (lowPtr < highPtr) {
         double totalBoost = initialBoost;
         totalBoost += fractionalBoost(lowPtr * 0.5) * firstHarmonicAmount;
         totalBoost += fractionalBoost(lowPtr * ONE_THIRD) * secondHarmonicAmount;
         totalBoost += fractionalBoost(lowPtr * 0.25) * thirdHarmonicAmount;
         
         double real = fftBins[lowPtr][0] * totalBoost;
         double imag = fftBins[lowPtr][1] * totalBoost;
         fftBins[lowPtr][0] = fftBins[highPtr][0] = real;
         fftBins[lowPtr][1] = imag;
         fftBins[highPtr][1] = -imag;
         
         lowPtr++;
         highPtr--;
      }
   }
   
   private double fractionalBoost(double fractionalIndex) {
     int floor = (int) fractionalIndex;
     int ceil = floor + 1;
     double amt = fractionalIndex - floor;
     return (magSquared[floor] * (1 - amt)) + (magSquared[ceil] * amt);
   }
}




   //[/user-code-and-variables]
}

 