package com.vulpuslabs.chebs;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.modules.chebz.*;
import java.util.function.DoubleConsumer;
import com.vulpuslabs.vulpes.values.ranges.Range;
import com.vulpuslabs.vulpes.values.inputs.CvModulatableKnob;
import com.vulpuslabs.vulpes.values.outputs.DisconnectableOutput;
import com.vulpuslabs.vulpes.values.events.NotificationReceiver;
//[/user-imports]


public class Chebz extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public Chebz( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Chebz", ModuleType.ModuleType_Utility, 4.2 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "ac442b0c265b4132b5a7f0f2f420bf82" );
   }

void InitializeControls()
{

      freqRect = new VoltageRectangle( "freqRect", "Frequency Controls", this );
      AddComponent( freqRect );
      freqRect.SetWantsMouseNotifications( false );
      freqRect.SetPosition( 10, 18 );
      freqRect.SetSize( 75, 326 );
      freqRect.SetRectangleColor( new Color( 165, 32, 32, 255 ) );
      freqRect.SetBorderColor( new Color( 0, 0, 0, 255 ) );
      freqRect.SetBorderSize( 0 );
      freqRect.SetCornerSize( 12 );

      rectangle3 = new VoltageRectangle( "rectangle3", "rectangle3", this );
      AddComponent( rectangle3 );
      rectangle3.SetWantsMouseNotifications( false );
      rectangle3.SetPosition( 20, 161 );
      rectangle3.SetSize( 55, 56 );
      rectangle3.SetRectangleColor( new Color( 96, 32, 32, 255 ) );
      rectangle3.SetBorderColor( new Color( 128, 32, 32, 255 ) );
      rectangle3.SetBorderSize( 2 );
      rectangle3.SetCornerSize( 8 );

      freqRect_1 = new VoltageRectangle( "freqRect_1", "Frequency Controls_1", this );
      AddComponent( freqRect_1 );
      freqRect_1.SetWantsMouseNotifications( false );
      freqRect_1.SetPosition( 250, 18 );
      freqRect_1.SetSize( 48, 229 );
      freqRect_1.SetRectangleColor( new Color( 165, 32, 32, 255 ) );
      freqRect_1.SetBorderColor( new Color( 0, 0, 0, 255 ) );
      freqRect_1.SetBorderSize( 0 );
      freqRect_1.SetCornerSize( 12 );

      coeff0Rect = new VoltageRectangle( "coeff0Rect", "Fundamental Controls", this );
      AddComponent( coeff0Rect );
      coeff0Rect.SetWantsMouseNotifications( false );
      coeff0Rect.SetPosition( 100, 18 );
      coeff0Rect.SetSize( 80, 24 );
      coeff0Rect.SetRectangleColor( new Color( 165, 32, 32, 255 ) );
      coeff0Rect.SetBorderColor( new Color( 0, 0, 0, 255 ) );
      coeff0Rect.SetBorderSize( 0 );
      coeff0Rect.SetCornerSize( 0 );

      allOut = new VoltageAudioJack( "allOut", "All Harmonics Out", this, JackType.JackType_AudioOutput );
      AddComponent( allOut );
      allOut.SetWantsMouseNotifications( false );
      allOut.SetPosition( 34, 266 );
      allOut.SetSize( 25, 25 );
      allOut.SetSkin( "Mini Jack 25px" );

      frequencyKnob = new VoltageKnob( "frequencyKnob", "Frequency", this, 16.3775, 1046.56, 65.41 );
      AddComponent( frequencyKnob );
      frequencyKnob.SetWantsMouseNotifications( false );
      frequencyKnob.SetPosition( 24, 24 );
      frequencyKnob.SetSize( 47, 47 );
      frequencyKnob.SetSkin( "Moog Rogue Pointer" );
      frequencyKnob.SetRange( 16.3775, 1046.56, 65.41, false, 0 );
      frequencyKnob.SetKnobParams( 215, 145 );
      frequencyKnob.SetUnits( "hz" );
      frequencyKnob.DisplayValueInPercent( false );
      frequencyKnob.SetKnobAdjustsRing( true );
      frequencyKnob.SetMidpointValue( 65.4 );

      waveformDisplay = new VoltageCanvas( "waveformDisplay", "Waveform Display", this, 49, 49 );
      AddComponent( waveformDisplay );
      waveformDisplay.SetWantsMouseNotifications( false );
      waveformDisplay.SetHighDensity( true );
      waveformDisplay.SetPosition( 23, 164 );
      waveformDisplay.SetSize( 49, 49 );

      evenOutput = new VoltageAudioJack( "evenOutput", "Even Harmonics Output", this, JackType.JackType_AudioOutput );
      AddComponent( evenOutput );
      evenOutput.SetWantsMouseNotifications( false );
      evenOutput.SetPosition( 52, 234 );
      evenOutput.SetSize( 25, 25 );
      evenOutput.SetSkin( "Mini Jack 25px" );

      oddOutput = new VoltageAudioJack( "oddOutput", "Odd Harmonics Output", this, JackType.JackType_AudioOutput );
      AddComponent( oddOutput );
      oddOutput.SetWantsMouseNotifications( false );
      oddOutput.SetPosition( 16, 234 );
      oddOutput.SetSize( 25, 25 );
      oddOutput.SetSkin( "Mini Jack 25px" );

      coeff0Out = new VoltageAudioJack( "coeff0Out", "Fundamental Output", this, JackType.JackType_AudioOutput );
      AddComponent( coeff0Out );
      coeff0Out.SetWantsMouseNotifications( false );
      coeff0Out.SetPosition( 220, 17 );
      coeff0Out.SetSize( 25, 25 );
      coeff0Out.SetSkin( "Mini Jack 25px" );

      voctInput = new VoltageAudioJack( "voctInput", "V/Oct Input", this, JackType.JackType_AudioInput );
      AddComponent( voctInput );
      voctInput.SetWantsMouseNotifications( false );
      voctInput.SetPosition( 16, 88 );
      voctInput.SetSize( 25, 25 );
      voctInput.SetSkin( "Mini Jack 25px" );

      fmInput = new VoltageAudioJack( "fmInput", "Frequency Modulation Input", this, JackType.JackType_AudioInput );
      AddComponent( fmInput );
      fmInput.SetWantsMouseNotifications( false );
      fmInput.SetPosition( 16, 117 );
      fmInput.SetSize( 25, 25 );
      fmInput.SetSkin( "Mini Jack 25px" );

      fmAmountKnob = new VoltageKnob( "fmAmountKnob", "Frequency Modulation Amount", this, -1.0, 1.0, 0 );
      AddComponent( fmAmountKnob );
      fmAmountKnob.SetWantsMouseNotifications( false );
      fmAmountKnob.SetPosition( 52, 119 );
      fmAmountKnob.SetSize( 21, 21 );
      fmAmountKnob.SetSkin( "Plastic Maroon" );
      fmAmountKnob.SetRange( -1.0, 1.0, 0, false, 0 );
      fmAmountKnob.SetKnobParams( 215, 145 );
      fmAmountKnob.DisplayValueInPercent( false );
      fmAmountKnob.SetKnobAdjustsRing( true );

      textLabel1 = new VoltageLabel( "textLabel1", "textLabel1", this, "V/OCT" );
      AddComponent( textLabel1 );
      textLabel1.SetWantsMouseNotifications( false );
      textLabel1.SetPosition( 45, 88 );
      textLabel1.SetSize( 40, 25 );
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

      textLabel2 = new VoltageLabel( "textLabel2", "textLabel2", this, "FREQUENCY" );
      AddComponent( textLabel2 );
      textLabel2.SetWantsMouseNotifications( false );
      textLabel2.SetPosition( 10, 72 );
      textLabel2.SetSize( 75, 16 );
      textLabel2.SetEditable( false, false );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel2.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel2.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel2.SetBkColor( new Color( 65, 65, 65, 0 ) );
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

      textLabel3 = new VoltageLabel( "textLabel3", "textLabel3", this, "FM" );
      AddComponent( textLabel3 );
      textLabel3.SetWantsMouseNotifications( false );
      textLabel3.SetPosition( 15, 143 );
      textLabel3.SetSize( 28, 20 );
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

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "ODD" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 9, 212 );
      textLabel4.SetSize( 35, 25 );
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

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "EVEN" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 49, 212 );
      textLabel5.SetSize( 35, 25 );
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

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "SMOOTHING" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 133, 318 );
      textLabel8.SetSize( 52, 25 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel8.SetColor( new Color( 255, 255, 255, 255 ) );
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
      textLabel8.SetFont( "Arial", 10, true, false );

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "SMOOTHING" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 250, 220 );
      textLabel13.SetSize( 48, 25 );
      textLabel13.SetEditable( false, false );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel13.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel13.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel13.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel13.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel13.SetBorderSize( 1 );
      textLabel13.SetMultiLineEdit( false );
      textLabel13.SetIsNumberEditor( false );
      textLabel13.SetNumberEditorRange( 0, 100 );
      textLabel13.SetNumberEditorInterval( 1 );
      textLabel13.SetNumberEditorUsesMouseWheel( false );
      textLabel13.SetHasCustomTextHoverColor( false );
      textLabel13.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel13.SetFont( "Arial", 8, true, false );

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "CHEBZ" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 0, 0 );
      textLabel6.SetSize( 302, 15 );
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

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "VULPUS LABS" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 0, 345 );
      textLabel7.SetSize( 302, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel7.SetColor( new Color( 255, 255, 255, 255 ) );
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
      textLabel7.SetFont( "Arial", 10, true, false );

      allOutLabel = new VoltageLabel( "allOutLabel", "allOutLabel", this, "ALL" );
      AddComponent( allOutLabel );
      allOutLabel.SetWantsMouseNotifications( false );
      allOutLabel.SetPosition( 9, 293 );
      allOutLabel.SetSize( 75, 15 );
      allOutLabel.SetEditable( false, false );
      allOutLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      allOutLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      allOutLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      allOutLabel.SetBkColor( new Color( 65, 65, 65, 0 ) );
      allOutLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      allOutLabel.SetBorderSize( 1 );
      allOutLabel.SetMultiLineEdit( false );
      allOutLabel.SetIsNumberEditor( false );
      allOutLabel.SetNumberEditorRange( 0, 100 );
      allOutLabel.SetNumberEditorInterval( 1 );
      allOutLabel.SetNumberEditorUsesMouseWheel( false );
      allOutLabel.SetHasCustomTextHoverColor( false );
      allOutLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      allOutLabel.SetFont( "Arial", 10, true, false );

      oversampleToggle = new VoltageToggle( "oversampleToggle", "Oversample Toggle", this, false, 0 );
      AddComponent( oversampleToggle );
      oversampleToggle.SetWantsMouseNotifications( false );
      oversampleToggle.SetPosition( 261, 24 );
      oversampleToggle.SetSize( 28, 15 );
      oversampleToggle.SetSkin( "Mini Rectangle Red" );
      oversampleToggle.ShowOverlay( false );
      oversampleToggle.SetOverlayText( "" );

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "OVER SAMPLE" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 250, 42 );
      textLabel9.SetSize( 48, 30 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel9.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel9.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel9.SetBorderSize( 1 );
      textLabel9.SetMultiLineEdit( true );
      textLabel9.SetIsNumberEditor( false );
      textLabel9.SetNumberEditorRange( 0, 100 );
      textLabel9.SetNumberEditorInterval( 1 );
      textLabel9.SetNumberEditorUsesMouseWheel( false );
      textLabel9.SetHasCustomTextHoverColor( false );
      textLabel9.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel9.SetFont( "Arial", 10, true, false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "+" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 73, 130 );
      textLabel10.SetSize( 8, 8 );
      textLabel10.SetEditable( false, false );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel10.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel10.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel10.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel10.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel10.SetBorderSize( 1 );
      textLabel10.SetMultiLineEdit( false );
      textLabel10.SetIsNumberEditor( false );
      textLabel10.SetNumberEditorRange( 0, 100 );
      textLabel10.SetNumberEditorInterval( 1 );
      textLabel10.SetNumberEditorUsesMouseWheel( false );
      textLabel10.SetHasCustomTextHoverColor( false );
      textLabel10.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel10.SetFont( "Arial", 12, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "-" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 44, 130 );
      textLabel11.SetSize( 8, 8 );
      textLabel11.SetEditable( false, false );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel11.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel11.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel11.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel11.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel11.SetBorderSize( 1 );
      textLabel11.SetMultiLineEdit( false );
      textLabel11.SetIsNumberEditor( false );
      textLabel11.SetNumberEditorRange( 0, 100 );
      textLabel11.SetNumberEditorInterval( 1 );
      textLabel11.SetNumberEditorUsesMouseWheel( false );
      textLabel11.SetHasCustomTextHoverColor( false );
      textLabel11.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel11.SetFont( "Arial", 12, true, false );

      coeff0Volume = new VoltageKnob( "coeff0Volume", "Fundamental Volume", this, -1.0, 1.0, 0.5 );
      AddComponent( coeff0Volume );
      coeff0Volume.SetWantsMouseNotifications( false );
      coeff0Volume.SetPosition( 165, 18 );
      coeff0Volume.SetSize( 27, 27 );
      coeff0Volume.SetSkin( "Plastic White" );
      coeff0Volume.SetRange( -1.0, 1.0, 0.5, false, 0 );
      coeff0Volume.SetKnobParams( 215, 145 );
      coeff0Volume.DisplayValueInPercent( false );
      coeff0Volume.SetKnobAdjustsRing( true );

      coeff0ModInput = new VoltageAudioJack( "coeff0ModInput", "Fundamental Mod Input", this, JackType.JackType_AudioInput );
      AddComponent( coeff0ModInput );
      coeff0ModInput.SetWantsMouseNotifications( false );
      coeff0ModInput.SetPosition( 90, 18 );
      coeff0ModInput.SetSize( 25, 25 );
      coeff0ModInput.SetSkin( "Mini Jack 25px" );

      coeff0ModAmount = new VoltageKnob( "coeff0ModAmount", "Fundamental Mod Amount", this, -1.0, 1.0, 0 );
      AddComponent( coeff0ModAmount );
      coeff0ModAmount.SetWantsMouseNotifications( false );
      coeff0ModAmount.SetPosition( 129, 20 );
      coeff0ModAmount.SetSize( 21, 21 );
      coeff0ModAmount.SetSkin( "Plastic Maroon" );
      coeff0ModAmount.SetRange( -1.0, 1.0, 0, false, 0 );
      coeff0ModAmount.SetKnobParams( 215, 145 );
      coeff0ModAmount.DisplayValueInPercent( false );
      coeff0ModAmount.SetKnobAdjustsRing( true );

      coeff0PlusLabel = new VoltageLabel( "coeff0PlusLabel", "textLabel26", this, "+" );
      AddComponent( coeff0PlusLabel );
      coeff0PlusLabel.SetWantsMouseNotifications( false );
      coeff0PlusLabel.SetPosition( 150, 32 );
      coeff0PlusLabel.SetSize( 8, 8 );
      coeff0PlusLabel.SetEditable( false, false );
      coeff0PlusLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      coeff0PlusLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      coeff0PlusLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      coeff0PlusLabel.SetBkColor( new Color( 65, 65, 65, 0 ) );
      coeff0PlusLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      coeff0PlusLabel.SetBorderSize( 0 );
      coeff0PlusLabel.SetMultiLineEdit( false );
      coeff0PlusLabel.SetIsNumberEditor( false );
      coeff0PlusLabel.SetNumberEditorRange( 0, 100 );
      coeff0PlusLabel.SetNumberEditorInterval( 1 );
      coeff0PlusLabel.SetNumberEditorUsesMouseWheel( false );
      coeff0PlusLabel.SetHasCustomTextHoverColor( false );
      coeff0PlusLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      coeff0PlusLabel.SetFont( "Arial", 12, true, false );

      textLabel27 = new VoltageLabel( "textLabel27", "textLabel27", this, "-" );
      AddComponent( textLabel27 );
      textLabel27.SetWantsMouseNotifications( false );
      textLabel27.SetPosition( 122, 32 );
      textLabel27.SetSize( 8, 8 );
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
      textLabel27.SetFont( "Arial", 12, true, false );

      fundamentalLabel = new VoltageLabel( "fundamentalLabel", "Fundamental Label", this, "0th" );
      AddComponent( fundamentalLabel );
      fundamentalLabel.SetWantsMouseNotifications( false );
      fundamentalLabel.SetPosition( 189, 22 );
      fundamentalLabel.SetSize( 30, 16 );
      fundamentalLabel.SetEditable( false, false );
      fundamentalLabel.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      fundamentalLabel.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      fundamentalLabel.SetColor( new Color( 255, 255, 255, 255 ) );
      fundamentalLabel.SetBkColor( new Color( 65, 65, 65, 0 ) );
      fundamentalLabel.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      fundamentalLabel.SetBorderSize( 1 );
      fundamentalLabel.SetMultiLineEdit( false );
      fundamentalLabel.SetIsNumberEditor( false );
      fundamentalLabel.SetNumberEditorRange( 0, 100 );
      fundamentalLabel.SetNumberEditorInterval( 1 );
      fundamentalLabel.SetNumberEditorUsesMouseWheel( false );
      fundamentalLabel.SetHasCustomTextHoverColor( false );
      fundamentalLabel.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      fundamentalLabel.SetFont( "Arial", 12, true, false );

      oddEvenBalanceKnob = new VoltageKnob( "oddEvenBalanceKnob", "Odd/Even Balance", this, 0, 1.0, 0.5 );
      AddComponent( oddEvenBalanceKnob );
      oddEvenBalanceKnob.SetWantsMouseNotifications( false );
      oddEvenBalanceKnob.SetPosition( 261, 79 );
      oddEvenBalanceKnob.SetSize( 27, 27 );
      oddEvenBalanceKnob.SetSkin( "Plastic White" );
      oddEvenBalanceKnob.SetRange( 0, 1.0, 0.5, false, 0 );
      oddEvenBalanceKnob.SetKnobParams( 215, 145 );
      oddEvenBalanceKnob.DisplayValueInPercent( false );
      oddEvenBalanceKnob.SetKnobAdjustsRing( true );

      oddEvenBalanceMod = new VoltageKnob( "oddEvenBalanceMod", "Odd/Even Balance Modulation Amount", this, -1.0, 1.0, 0 );
      AddComponent( oddEvenBalanceMod );
      oddEvenBalanceMod.SetWantsMouseNotifications( false );
      oddEvenBalanceMod.SetPosition( 264, 115 );
      oddEvenBalanceMod.SetSize( 21, 21 );
      oddEvenBalanceMod.SetSkin( "Plastic Maroon" );
      oddEvenBalanceMod.SetRange( -1.0, 1.0, 0, false, 0 );
      oddEvenBalanceMod.SetKnobParams( 215, 145 );
      oddEvenBalanceMod.DisplayValueInPercent( false );
      oddEvenBalanceMod.SetKnobAdjustsRing( true );

      coeff0PlusLabel_1 = new VoltageLabel( "coeff0PlusLabel_1", "textLabel28", this, "+" );
      AddComponent( coeff0PlusLabel_1 );
      coeff0PlusLabel_1.SetWantsMouseNotifications( false );
      coeff0PlusLabel_1.SetPosition( 285, 130 );
      coeff0PlusLabel_1.SetSize( 8, 8 );
      coeff0PlusLabel_1.SetEditable( false, false );
      coeff0PlusLabel_1.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      coeff0PlusLabel_1.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      coeff0PlusLabel_1.SetColor( new Color( 255, 255, 255, 255 ) );
      coeff0PlusLabel_1.SetBkColor( new Color( 65, 65, 65, 0 ) );
      coeff0PlusLabel_1.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      coeff0PlusLabel_1.SetBorderSize( 0 );
      coeff0PlusLabel_1.SetMultiLineEdit( false );
      coeff0PlusLabel_1.SetIsNumberEditor( false );
      coeff0PlusLabel_1.SetNumberEditorRange( 0, 100 );
      coeff0PlusLabel_1.SetNumberEditorInterval( 1 );
      coeff0PlusLabel_1.SetNumberEditorUsesMouseWheel( false );
      coeff0PlusLabel_1.SetHasCustomTextHoverColor( false );
      coeff0PlusLabel_1.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      coeff0PlusLabel_1.SetFont( "Arial", 12, true, false );

      textLabel28 = new VoltageLabel( "textLabel28", "textLabel29", this, "-" );
      AddComponent( textLabel28 );
      textLabel28.SetWantsMouseNotifications( false );
      textLabel28.SetPosition( 257, 130 );
      textLabel28.SetSize( 8, 8 );
      textLabel28.SetEditable( false, false );
      textLabel28.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel28.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel28.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel28.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel28.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel28.SetBorderSize( 1 );
      textLabel28.SetMultiLineEdit( false );
      textLabel28.SetIsNumberEditor( false );
      textLabel28.SetNumberEditorRange( 0, 100 );
      textLabel28.SetNumberEditorInterval( 1 );
      textLabel28.SetNumberEditorUsesMouseWheel( false );
      textLabel28.SetHasCustomTextHoverColor( false );
      textLabel28.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel28.SetFont( "Arial", 12, true, false );

      oddEvenBalanceCv = new VoltageAudioJack( "oddEvenBalanceCv", "Odd/Even Balance CV", this, JackType.JackType_AudioInput );
      AddComponent( oddEvenBalanceCv );
      oddEvenBalanceCv.SetWantsMouseNotifications( false );
      oddEvenBalanceCv.SetPosition( 262, 146 );
      oddEvenBalanceCv.SetSize( 25, 25 );
      oddEvenBalanceCv.SetSkin( "Mini Jack 25px" );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "ODD / EVEN BALANCE" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 250, 175 );
      textLabel12.SetSize( 48, 30 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel12.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel12.SetBorderSize( 1 );
      textLabel12.SetMultiLineEdit( true );
      textLabel12.SetIsNumberEditor( false );
      textLabel12.SetNumberEditorRange( 0, 100 );
      textLabel12.SetNumberEditorInterval( 1 );
      textLabel12.SetNumberEditorUsesMouseWheel( false );
      textLabel12.SetHasCustomTextHoverColor( false );
      textLabel12.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel12.SetFont( "Arial", 9, true, false );

      oddEvenSmoothingSwitch = new VoltageSwitch( "oddEvenSmoothingSwitch", "Odd/Even Smoothing", this, 1 );
      AddComponent( oddEvenSmoothingSwitch );
      oddEvenSmoothingSwitch.SetWantsMouseNotifications( false );
      oddEvenSmoothingSwitch.SetPosition( 256, 200 );
      oddEvenSmoothingSwitch.SetSize( 35, 35 );
      oddEvenSmoothingSwitch.SetSkin( "3-State Bar Red Horizontal" );

      harmonicSmoothingSwitch = new VoltageSwitch( "harmonicSmoothingSwitch", "Harmonic Level Smoothing", this, 1 );
      AddComponent( harmonicSmoothingSwitch );
      harmonicSmoothingSwitch.SetWantsMouseNotifications( false );
      harmonicSmoothingSwitch.SetPosition( 89, 313 );
      harmonicSmoothingSwitch.SetSize( 35, 35 );
      harmonicSmoothingSwitch.SetSkin( "3-State Bar Red Horizontal" );

      waveFoldingSwitch = new VoltageSwitch( "waveFoldingSwitch", "Wave Folding", this, 0 );
      AddComponent( waveFoldingSwitch );
      waveFoldingSwitch.SetWantsMouseNotifications( false );
      waveFoldingSwitch.SetPosition( 30, 302 );
      waveFoldingSwitch.SetSize( 35, 35 );
      waveFoldingSwitch.SetSkin( "2-State Bar Red Horizontal" );

      modBypassSwitch = new VoltageSwitch( "modBypassSwitch", "Modulation Bypass", this, 0 );
      AddComponent( modBypassSwitch );
      modBypassSwitch.SetWantsMouseNotifications( false );
      modBypassSwitch.SetPosition( 193, 313 );
      modBypassSwitch.SetSize( 35, 35 );
      modBypassSwitch.SetSkin( "2-State Bar Horizontal" );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "FOLDING" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 24, 324 );
      textLabel14.SetSize( 48, 25 );
      textLabel14.SetEditable( false, false );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel14.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel14.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel14.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel14.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel14.SetBorderSize( 1 );
      textLabel14.SetMultiLineEdit( false );
      textLabel14.SetIsNumberEditor( false );
      textLabel14.SetNumberEditorRange( 0, 100 );
      textLabel14.SetNumberEditorInterval( 1 );
      textLabel14.SetNumberEditorUsesMouseWheel( false );
      textLabel14.SetHasCustomTextHoverColor( false );
      textLabel14.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel14.SetFont( "Arial", 8, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "MOD BYPASS" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 237, 317 );
      textLabel15.SetSize( 52, 25 );
      textLabel15.SetEditable( false, false );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel15.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel15.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel15.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel15.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel15.SetBorderSize( 1 );
      textLabel15.SetMultiLineEdit( false );
      textLabel15.SetIsNumberEditor( false );
      textLabel15.SetNumberEditorRange( 0, 100 );
      textLabel15.SetNumberEditorInterval( 1 );
      textLabel15.SetNumberEditorUsesMouseWheel( false );
      textLabel15.SetHasCustomTextHoverColor( false );
      textLabel15.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel15.SetFont( "Arial", 10, true, false );
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
      makeCoeffControls();
      
      CvModulatableKnob[] harmonicKnobs = new CvModulatableKnob[10];
      for (int i=0; i<10; i++) {
         harmonicKnobs[i] = new CvModulatableKnob(
            -1.0, 1.0,
            receiver.registerInput(coeffInputs[i], coeffInputs[i]::GetValue),
            receiver.registerSmoothedKnob(coeffVolKnobs[i], coeffVolKnobs[i].GetValue()),
            receiver.registerSmoothedKnob(coeffModKnobs[i], 0.0));
      }
      
      CvModulatableKnob oddEvenBalance = new CvModulatableKnob(
         0.0, 1.0,
         receiver.registerInput(oddEvenBalanceCv, oddEvenBalanceCv::GetValue),
         receiver.registerSmoothedKnob(oddEvenBalanceKnob, oddEvenBalanceKnob.GetValue()),
         receiver.registerSmoothedKnob(oddEvenBalanceMod, 0.0));
         
      inputBus = new InputBus(
         harmonicKnobs,
         receiver.registerInput(voctInput, voctInput::GetValue),
         receiver.registerInput(fmInput, fmInput::GetValue),
         receiver.registerSmoothedKnob(frequencyKnob, frequencyKnob.GetValue()),
         receiver.registerSmoothableInput(oddEvenSmoothingSwitch, oddEvenBalance, 0.01, 0.001));
         
      receiver.registerKnob(fmAmountKnob, fmAmountKnob.GetValue(), inputBus::setFmAmount);
      receiver.registerControllableSmoothing(harmonicSmoothingSwitch, inputBus, 0.01, 0.001);
      
      DisconnectableOutput[] individualOuts = new DisconnectableOutput[10];
      for (int i=0; i<10; i++) {
         individualOuts[i] = receiver.registerOutput(harmonicOuts[i], harmonicOuts[i]::SetValue);
      }
      
      outputBus = new OutputBus(
         individualOuts,
         receiver.registerOutput(oddOutput, oddOutput::SetValue),
         receiver.registerOutput(evenOutput, evenOutput::SetValue),
         receiver.registerOutput(allOut, allOut::SetValue));
      
      model = new ChebzModel(inputBus, outputBus);
      
      receiver.registerTwoStateSwitch(waveFoldingSwitch, model::setWavefoldingActive)
         .registerTwoStateSwitch(modBypassSwitch, model::setModulationBypass);
         
      view = new ChebzView(model, waveformDisplay.GetBitmapWidth(), waveformDisplay.GetBitmapHeight());
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
         case Knob_Changed: return receiver.knobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed:   // doubleValue is the new button/toggle button value
         {
            if (doubleValue == 0.0) {
               model.setOversamplingFactor(1);
            } else {
               model.setOversamplingFactor(8);
            }
         }
         break;
      
         case Switch_Changed: return receiver.switchChanged(component, doubleValue);
      
      
         case Jack_Connected: return receiver.jackConnected(component);
      
         case Jack_Disconnected: return receiver.jackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            waveformDisplay.Invalidate();
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
            view.redraw(waveformDisplay.GetGraphics());
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
      model.processSample();


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
      if (component == waveFoldingSwitch) {
         return "Wavefolding " + (waveFoldingSwitch.GetValue() == 1.0 ? "On" : "Off");
      }
      
      if (component == harmonicSmoothingSwitch) {
         return "Harmonic Modulation Smoothing " + (harmonicSmoothingSwitch.GetValue() == 0.0 ? "Off" :
            (harmonicSmoothingSwitch.GetValue() == 1.0 ? "Medium" : "High"));
      }
      
      if (component == oddEvenSmoothingSwitch) {
         return "Odd/Even Modulation Smoothing " + (oddEvenSmoothingSwitch.GetValue() == 0.0 ? "Off" :
            (oddEvenSmoothingSwitch.GetValue() == 1.0 ? "Medium" : "High"));
      }
      
      if (component == modBypassSwitch) {
         return "Modulation Bypass " + (modBypassSwitch.GetValue() == 1.0 ? "On" : "Off");
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
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageSwitch modBypassSwitch;
   private VoltageSwitch waveFoldingSwitch;
   private VoltageSwitch harmonicSmoothingSwitch;
   private VoltageSwitch oddEvenSmoothingSwitch;
   private VoltageLabel textLabel12;
   private VoltageAudioJack oddEvenBalanceCv;
   private VoltageLabel textLabel28;
   private VoltageLabel coeff0PlusLabel_1;
   private VoltageKnob oddEvenBalanceMod;
   private VoltageKnob oddEvenBalanceKnob;
   private VoltageLabel fundamentalLabel;
   private VoltageLabel textLabel27;
   private VoltageLabel coeff0PlusLabel;
   private VoltageKnob coeff0ModAmount;
   private VoltageAudioJack coeff0ModInput;
   private VoltageKnob coeff0Volume;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel10;
   private VoltageLabel textLabel9;
   private VoltageToggle oversampleToggle;
   private VoltageLabel allOutLabel;
   private VoltageLabel textLabel7;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageLabel textLabel3;
   private VoltageLabel textLabel2;
   private VoltageLabel textLabel1;
   private VoltageKnob fmAmountKnob;
   private VoltageAudioJack fmInput;
   private VoltageAudioJack voctInput;
   private VoltageAudioJack coeff0Out;
   private VoltageAudioJack oddOutput;
   private VoltageAudioJack evenOutput;
   private VoltageCanvas waveformDisplay;
   private VoltageKnob frequencyKnob;
   private VoltageAudioJack allOut;
   private VoltageRectangle coeff0Rect;
   private VoltageRectangle freqRect_1;
   private VoltageRectangle rectangle3;
   private VoltageRectangle freqRect;


   //[user-code-and-variables]    Add your own variables and functions here
private VoltageAudioJack[] coeffInputs = new VoltageAudioJack[10];
private VoltageKnob[] coeffModKnobs = new VoltageKnob[10];
private VoltageKnob[] coeffVolKnobs = new VoltageKnob[10];
private VoltageAudioJack[] harmonicOuts = new VoltageAudioJack[10];
private String[] labels = new String[] {
  "0th", "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th"
};
private InputBus inputBus;
private OutputBus outputBus;
private ChebzModel model;
private ChebzView view;
private NotificationReceiver receiver = new NotificationReceiver();

private void makeCoeffControls() {
   coeffInputs[0] = coeff0ModInput;
   coeffModKnobs[0] = coeff0ModAmount;
   coeffVolKnobs[0] = coeff0Volume;
   harmonicOuts[0] = coeff0Out;
   
   for (int i=1; i<10; i++) {
      makeCoeffControl(i);
   }

}

private void makeCoeffControl(int i) {
   var top = i * 30;
   
   makeRect(i, top);
   makeCoeffKnob(i, top);
   makeModAmount(i, top);  
   makePlusLabel(i, top);
   makeMinusLabel(i, top);
   makeModInput(i, top);
   makeHarmonicLabel(i, top);
   makeHarmonicOut(i, top);
   
}

private void makeRect(int i, int top) {   
   VoltageRectangle rect = new VoltageRectangle(
      "coeff0Rect",
      labels[i] + " Harmonic Controls",
      this);
   AddComponent(rect);
   rect.SetWantsMouseNotifications(false);
   rect.SetPosition(100, 18 + top);
   rect.SetSize(80, 24);
   rect.SetRectangleColor(new Color(165, 32, 32, 255));
   rect.SetBorderSize(0);
   rect.SetCornerSize(12);
}

private void makeModInput(int i, int top) {
   VoltageAudioJack input = new VoltageAudioJack(
        "coeff" + i + "ModInput",
        labels[i] + " Harmonic Mod Input",
        this,
        JackType.JackType_AudioInput
     );
     AddComponent(input);
     input.SetWantsMouseNotifications(false);
     input.SetPosition(90, 18 + top);
     input.SetSize(25, 25);
     input.SetSkin(coeff0ModInput.GetSkin());
     coeffInputs[i] = input;
}

private void makePlusLabel(int i, int top) {
        var label = new VoltageLabel(
           "coeff" + i + "PlusLabel", 
           "coeff" + i + "PlusLabel",
           this,
           "+");
        AddComponent(label);
        label.SetWantsMouseNotifications(false);
        label.SetPosition(150, 32 + top);
        label.SetSize(8, 8);
        label.SetEditable(false, false);
        label.SetJustificationFlags(VoltageLabel.Justification.HorizCentered);
        label.SetJustificationFlags(VoltageLabel.Justification.VertCentered);
        label.SetColor(new Color(255, 255, 255, 255));
        label.SetBkColor(new Color(65, 65, 65, 0));
        label.SetBorderSize(0);
        label.SetMultiLineEdit(false);
        label.SetIsNumberEditor(false);
        label.SetHasCustomTextHoverColor(false);
        label.SetFont("Arial", 12, true, false);
}

private void makeMinusLabel(int i, int top) {
        var label = new VoltageLabel(
           "coeff" + i + "MinusLabel", 
           "coeff" + i + "MinusLabel",
           this,
           "-");
        AddComponent(label);
        label.SetWantsMouseNotifications(false);
        label.SetPosition(123, 32 + top);
        label.SetSize(8, 8);
        label.SetEditable(false, false);
        label.SetJustificationFlags(VoltageLabel.Justification.HorizCentered);
        label.SetJustificationFlags(VoltageLabel.Justification.VertCentered);
        label.SetColor(new Color(255, 255, 255, 255));
        label.SetBkColor(new Color(65, 65, 65, 0));
        label.SetBorderSize(0);
        label.SetMultiLineEdit(false);
        label.SetIsNumberEditor(false);
        label.SetHasCustomTextHoverColor(false);
        label.SetFont("Arial", 12, true, false);
}

private void makeHarmonicLabel(int i, int top) {
      var label = new VoltageLabel(
         "coeff" + i + "label",
          "coeff" + i + "label",
          this,
          labels[i]);
      AddComponent(label);
      label.SetPosition(189, 22 + top);
      label.SetSize(30, 16);
      label.SetEditable( false, false );
      label.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      label.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      label.SetColor( new Color( 255, 255, 255, 255 ) );
      label.SetBkColor( new Color( 65, 65, 65, 0 ) );
      label.SetBorderSize(0);
      label.SetMultiLineEdit( false );
      label.SetIsNumberEditor( false );
      label.SetHasCustomTextHoverColor( false );
      label.SetFont( "Arial", 12, true, false );
}

private void makeModAmount(int i, int top) {
      var knob = new VoltageKnob(
         "coeff" + i + "ModAmount",
         labels[i] + " Harmonic Mod Amount",
         this,
         -1.0,
         1.0,
         0.0);
      AddComponent(knob);
      knob.SetWantsMouseNotifications( false );
      knob.SetPosition(129, 20 + top);
      knob.SetSize(21, 21);
      knob.SetSkin( "Plastic Maroon" );
      knob.SetRange( -1.0, 1.0, 0, false, 0 );
      knob.SetKnobParams( 215, 145 );
      knob.DisplayValueInPercent(true);
      knob.SetKnobAdjustsRing(true);
      coeffModKnobs[i] = knob;
}

private void makeCoeffKnob(int i, int top) {
      var knob = new VoltageKnob(
         "coeff" + i + "Volume",
         labels[i] + " Harmonic Volume",
         this,
         -1.0,
         1.0,
         0.5);
      AddComponent(knob);
      knob.SetWantsMouseNotifications( false );
      knob.SetPosition( 165, 18 + top);
      knob.SetSize( 27, 27 );
      knob.SetSkin( "Plastic White" );
      knob.SetRange( -1.0, 1.0, 0.0, false, 0 );
      knob.SetKnobParams( 215, 145 );
      knob.DisplayValueInPercent( true );
      knob.SetKnobAdjustsRing( true );
      coeffVolKnobs[i] = knob;
}

private void makeHarmonicOut(int i, int top) {
      var jack = new VoltageAudioJack(
         "coeff" + i + "Out",
         labels[i] + " Harmonic Output",
         this,
         JackType.JackType_AudioOutput );
      AddComponent( jack );
      jack.SetWantsMouseNotifications( false );
      jack.SetPosition( 220, 18 + top );
      jack.SetSize( 25, 25 );
      jack.SetSkin( "Mini Jack 25px" );
      harmonicOuts[i] = jack;
}
   //[/user-code-and-variables]
}

 