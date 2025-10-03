package com.vulpuslabs.tormentnexus;


import voltage.controllers.*;
import voltage.core.*;
import voltage.core.Jack.JackType;
import voltage.sources.*;
import voltage.utility.*;
import voltage.processors.*;
import voltage.effects.*;
import java.awt.*;

//[user-imports]   Add your own imports here
import com.vulpuslabs.vulpes.values.events.*;
import com.vulpuslabs.vulpes.modules.torment.*;


//[/user-imports]


public class TormentNexus extends VoltageModule
//[user-inheritance]
//[/user-inheritance]
{

   public TormentNexus( long moduleID, VoltageObjects voltageObjects )
   {
      super( moduleID, voltageObjects, "Torment Nexus", ModuleType.ModuleType_Effect, 3.0 );

      InitializeControls();


      canBeBypassed = false;
      SetSkin( "47c47be4a720462899964181928fd9c8" );
   }

void InitializeControls()
{

      carrierInput = new VoltageAudioJack( "carrierInput", "Carrier Input", this, JackType.JackType_AudioInput );
      AddComponent( carrierInput );
      carrierInput.SetWantsMouseNotifications( false );
      carrierInput.SetPosition( 16, 42 );
      carrierInput.SetSize( 25, 25 );
      carrierInput.SetSkin( "Jack Round Cream Ring" );

      modulationInput = new VoltageAudioJack( "modulationInput", "Modulation Input", this, JackType.JackType_AudioInput );
      AddComponent( modulationInput );
      modulationInput.SetWantsMouseNotifications( false );
      modulationInput.SetPosition( 124, 42 );
      modulationInput.SetSize( 25, 25 );
      modulationInput.SetSkin( "Jack Round Mint Ring" );

      output = new VoltageAudioJack( "output", "Output", this, JackType.JackType_AudioOutput );
      AddComponent( output );
      output.SetWantsMouseNotifications( false );
      output.SetPosition( 124, 241 );
      output.SetSize( 25, 25 );
      output.SetSkin( "Jack Round Pink Ring" );

      modulationShapingSwitch = new VoltageSwitch( "modulationShapingSwitch", "Modulation Shaping Switch", this, 2 );
      AddComponent( modulationShapingSwitch );
      modulationShapingSwitch.SetWantsMouseNotifications( false );
      modulationShapingSwitch.SetPosition( 156, 42 );
      modulationShapingSwitch.SetSize( 13, 31 );
      modulationShapingSwitch.SetSkin( "3-State Slide Black" );

      textLabel4 = new VoltageLabel( "textLabel4", "textLabel4", this, "CLIP" );
      AddComponent( textLabel4 );
      textLabel4.SetWantsMouseNotifications( false );
      textLabel4.SetPosition( 180, 36 );
      textLabel4.SetSize( 30, 15 );
      textLabel4.SetEditable( false, false );
      textLabel4.SetJustificationFlags( VoltageLabel.Justification.Left );
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

      textLabel5 = new VoltageLabel( "textLabel5", "textLabel5", this, "FOLD" );
      AddComponent( textLabel5 );
      textLabel5.SetWantsMouseNotifications( false );
      textLabel5.SetPosition( 180, 50 );
      textLabel5.SetSize( 30, 15 );
      textLabel5.SetEditable( false, false );
      textLabel5.SetJustificationFlags( VoltageLabel.Justification.Left );
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

      textLabel6 = new VoltageLabel( "textLabel6", "textLabel6", this, "SAT" );
      AddComponent( textLabel6 );
      textLabel6.SetWantsMouseNotifications( false );
      textLabel6.SetPosition( 180, 65 );
      textLabel6.SetSize( 30, 15 );
      textLabel6.SetEditable( false, false );
      textLabel6.SetJustificationFlags( VoltageLabel.Justification.Left );
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

      carrierShapingSwitch = new VoltageSwitch( "carrierShapingSwitch", "Carrier Shaping Switch", this, 2 );
      AddComponent( carrierShapingSwitch );
      carrierShapingSwitch.SetWantsMouseNotifications( false );
      carrierShapingSwitch.SetPosition( 46, 42 );
      carrierShapingSwitch.SetSize( 13, 31 );
      carrierShapingSwitch.SetSkin( "3-State Slide Black" );

      textLabel7 = new VoltageLabel( "textLabel7", "textLabel7", this, "CLIP" );
      AddComponent( textLabel7 );
      textLabel7.SetWantsMouseNotifications( false );
      textLabel7.SetPosition( 70, 36 );
      textLabel7.SetSize( 30, 15 );
      textLabel7.SetEditable( false, false );
      textLabel7.SetJustificationFlags( VoltageLabel.Justification.Left );
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

      textLabel8 = new VoltageLabel( "textLabel8", "textLabel8", this, "FOLD" );
      AddComponent( textLabel8 );
      textLabel8.SetWantsMouseNotifications( false );
      textLabel8.SetPosition( 70, 50 );
      textLabel8.SetSize( 30, 15 );
      textLabel8.SetEditable( false, false );
      textLabel8.SetJustificationFlags( VoltageLabel.Justification.Left );
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

      textLabel9 = new VoltageLabel( "textLabel9", "textLabel9", this, "SAT" );
      AddComponent( textLabel9 );
      textLabel9.SetWantsMouseNotifications( false );
      textLabel9.SetPosition( 70, 65 );
      textLabel9.SetSize( 30, 15 );
      textLabel9.SetEditable( false, false );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel9.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel9.SetColor( new Color( 255, 255, 255, 255 ) );
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
      textLabel9.SetFont( "Arial", 10, true, false );

      carrierMeter = new VoltageVUMeter( "carrierMeter", "Carrier Meter", this );
      AddComponent( carrierMeter );
      carrierMeter.SetWantsMouseNotifications( false );
      carrierMeter.SetPosition( 82, 92 );
      carrierMeter.SetSize( 15, 41 );
      carrierMeter.SetSkin( "Small Meter" );
      carrierMeter.SetLinearMode( false );

      textLabel10 = new VoltageLabel( "textLabel10", "textLabel10", this, "TORMENT NEXUS" );
      AddComponent( textLabel10 );
      textLabel10.SetWantsMouseNotifications( false );
      textLabel10.SetPosition( 0, 0 );
      textLabel10.SetSize( 216, 15 );
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
      textLabel10.SetFont( "Arial", 10, true, false );

      textLabel11 = new VoltageLabel( "textLabel11", "textLabel11", this, "VULPUS LABS" );
      AddComponent( textLabel11 );
      textLabel11.SetWantsMouseNotifications( false );
      textLabel11.SetPosition( 0, 345 );
      textLabel11.SetSize( 216, 15 );
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
      textLabel11.SetFont( "Arial", 10, true, false );

      textLabel12 = new VoltageLabel( "textLabel12", "textLabel12", this, "CARRIER" );
      AddComponent( textLabel12 );
      textLabel12.SetWantsMouseNotifications( false );
      textLabel12.SetPosition( 0, 20 );
      textLabel12.SetSize( 108, 15 );
      textLabel12.SetEditable( false, false );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel12.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel12.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel12.SetBkColor( new Color( 65, 65, 65, 0 ) );
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

      textLabel13 = new VoltageLabel( "textLabel13", "textLabel13", this, "MODULATION" );
      AddComponent( textLabel13 );
      textLabel13.SetWantsMouseNotifications( false );
      textLabel13.SetPosition( 108, 20 );
      textLabel13.SetSize( 108, 15 );
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
      textLabel13.SetFont( "Arial", 10, true, false );

      textLabel27 = new VoltageLabel( "textLabel27", "textLabel27", this, "TORMENT SELECTOR" );
      AddComponent( textLabel27 );
      textLabel27.SetWantsMouseNotifications( false );
      textLabel27.SetPosition( 20, 170 );
      textLabel27.SetSize( 54, 26 );
      textLabel27.SetEditable( false, false );
      textLabel27.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel27.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel27.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel27.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel27.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel27.SetBorderSize( 1 );
      textLabel27.SetMultiLineEdit( true );
      textLabel27.SetIsNumberEditor( false );
      textLabel27.SetNumberEditorRange( 0, 100 );
      textLabel27.SetNumberEditorInterval( 1 );
      textLabel27.SetNumberEditorUsesMouseWheel( false );
      textLabel27.SetHasCustomTextHoverColor( false );
      textLabel27.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel27.SetFont( "Arial", 10, true, false );

      modulationMeter = new VoltageVUMeter( "modulationMeter", "Modulation Meter", this );
      AddComponent( modulationMeter );
      modulationMeter.SetWantsMouseNotifications( false );
      modulationMeter.SetPosition( 190, 92 );
      modulationMeter.SetSize( 15, 41 );
      modulationMeter.SetSkin( "Small Meter" );
      modulationMeter.SetLinearMode( false );

      textLabel14 = new VoltageLabel( "textLabel14", "textLabel14", this, "IN" );
      AddComponent( textLabel14 );
      textLabel14.SetWantsMouseNotifications( false );
      textLabel14.SetPosition( 8, 70 );
      textLabel14.SetSize( 40, 15 );
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
      textLabel14.SetFont( "Arial", 10, true, false );

      textLabel15 = new VoltageLabel( "textLabel15", "textLabel15", this, "IN" );
      AddComponent( textLabel15 );
      textLabel15.SetWantsMouseNotifications( false );
      textLabel15.SetPosition( 116, 70 );
      textLabel15.SetSize( 40, 15 );
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

      carrierAmpCv = new VoltageAudioJack( "carrierAmpCv", "Carrier Amp CV", this, JackType.JackType_AudioInput );
      AddComponent( carrierAmpCv );
      carrierAmpCv.SetWantsMouseNotifications( false );
      carrierAmpCv.SetPosition( 8, 92 );
      carrierAmpCv.SetSize( 25, 25 );
      carrierAmpCv.SetSkin( "Jack Round Cream Ring" );

      carrierFeedbackCv = new VoltageAudioJack( "carrierFeedbackCv", "Carrier Feedback CV", this, JackType.JackType_AudioInput );
      AddComponent( carrierFeedbackCv );
      carrierFeedbackCv.SetWantsMouseNotifications( false );
      carrierFeedbackCv.SetPosition( 18, 243 );
      carrierFeedbackCv.SetSize( 25, 25 );
      carrierFeedbackCv.SetSkin( "Jack Round Cream Ring" );

      modulationFeedbackCv = new VoltageAudioJack( "modulationFeedbackCv", "Modulation Feedback CV", this, JackType.JackType_AudioInput );
      AddComponent( modulationFeedbackCv );
      modulationFeedbackCv.SetWantsMouseNotifications( false );
      modulationFeedbackCv.SetPosition( 18, 292 );
      modulationFeedbackCv.SetSize( 25, 25 );
      modulationFeedbackCv.SetSkin( "Jack Round Cream Ring" );

      textLabel16 = new VoltageLabel( "textLabel16", "textLabel16", this, "AMP CV" );
      AddComponent( textLabel16 );
      textLabel16.SetWantsMouseNotifications( false );
      textLabel16.SetPosition( 8, 120 );
      textLabel16.SetSize( 40, 15 );
      textLabel16.SetEditable( false, false );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel16.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel16.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel16.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel16.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel16.SetBorderSize( 1 );
      textLabel16.SetMultiLineEdit( false );
      textLabel16.SetIsNumberEditor( false );
      textLabel16.SetNumberEditorRange( 0, 100 );
      textLabel16.SetNumberEditorInterval( 1 );
      textLabel16.SetNumberEditorUsesMouseWheel( false );
      textLabel16.SetHasCustomTextHoverColor( false );
      textLabel16.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel16.SetFont( "Arial", 10, true, false );

      textLabel31 = new VoltageLabel( "textLabel31", "textLabel31", this, "RECTIFY" );
      AddComponent( textLabel31 );
      textLabel31.SetWantsMouseNotifications( false );
      textLabel31.SetPosition( 15, 135 );
      textLabel31.SetSize( 40, 15 );
      textLabel31.SetEditable( false, false );
      textLabel31.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel31.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel31.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel31.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel31.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel31.SetBorderSize( 1 );
      textLabel31.SetMultiLineEdit( false );
      textLabel31.SetIsNumberEditor( false );
      textLabel31.SetNumberEditorRange( 0, 100 );
      textLabel31.SetNumberEditorInterval( 1 );
      textLabel31.SetNumberEditorUsesMouseWheel( false );
      textLabel31.SetHasCustomTextHoverColor( false );
      textLabel31.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel31.SetFont( "Arial", 10, true, false );

      textLabel32 = new VoltageLabel( "textLabel32", "textLabel32", this, "RECTIFY" );
      AddComponent( textLabel32 );
      textLabel32.SetWantsMouseNotifications( false );
      textLabel32.SetPosition( 123, 135 );
      textLabel32.SetSize( 40, 15 );
      textLabel32.SetEditable( false, false );
      textLabel32.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel32.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel32.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel32.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel32.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel32.SetBorderSize( 1 );
      textLabel32.SetMultiLineEdit( false );
      textLabel32.SetIsNumberEditor( false );
      textLabel32.SetNumberEditorRange( 0, 100 );
      textLabel32.SetNumberEditorInterval( 1 );
      textLabel32.SetNumberEditorUsesMouseWheel( false );
      textLabel32.SetHasCustomTextHoverColor( false );
      textLabel32.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel32.SetFont( "Arial", 10, true, false );

      textLabel33 = new VoltageLabel( "textLabel33", "textLabel33", this, "DC BIAS" );
      AddComponent( textLabel33 );
      textLabel33.SetWantsMouseNotifications( false );
      textLabel33.SetPosition( 143, 198 );
      textLabel33.SetSize( 44, 15 );
      textLabel33.SetEditable( false, false );
      textLabel33.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel33.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel33.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel33.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel33.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel33.SetBorderSize( 1 );
      textLabel33.SetMultiLineEdit( false );
      textLabel33.SetIsNumberEditor( false );
      textLabel33.SetNumberEditorRange( 0, 100 );
      textLabel33.SetNumberEditorInterval( 1 );
      textLabel33.SetNumberEditorUsesMouseWheel( false );
      textLabel33.SetHasCustomTextHoverColor( false );
      textLabel33.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel33.SetFont( "Arial", 10, true, false );

      carrierFeedbackKnob = new VoltageKnob( "carrierFeedbackKnob", "Carrier Feedback", this, -2, 2, 0 );
      AddComponent( carrierFeedbackKnob );
      carrierFeedbackKnob.SetWantsMouseNotifications( false );
      carrierFeedbackKnob.SetPosition( 62, 241 );
      carrierFeedbackKnob.SetSize( 27, 27 );
      carrierFeedbackKnob.SetSkin( "Plastic White" );
      carrierFeedbackKnob.SetRange( -2, 2, 0, false, 0 );
      carrierFeedbackKnob.SetKnobParams( 215, 145 );
      carrierFeedbackKnob.DisplayValueInPercent( true );
      carrierFeedbackKnob.SetKnobAdjustsRing( true );

      carrierAmpKnob = new VoltageKnob( "carrierAmpKnob", "Carrier Amp", this, -2, 2, 1 );
      AddComponent( carrierAmpKnob );
      carrierAmpKnob.SetWantsMouseNotifications( false );
      carrierAmpKnob.SetPosition( 52, 90 );
      carrierAmpKnob.SetSize( 27, 27 );
      carrierAmpKnob.SetSkin( "Plastic White" );
      carrierAmpKnob.SetRange( -2, 2, 1, false, 0 );
      carrierAmpKnob.SetKnobParams( 215, 145 );
      carrierAmpKnob.DisplayValueInPercent( true );
      carrierAmpKnob.SetKnobAdjustsRing( true );

      modulationFeedbackKnob = new VoltageKnob( "modulationFeedbackKnob", "Modulation Feedback", this, -2, 2, 0 );
      AddComponent( modulationFeedbackKnob );
      modulationFeedbackKnob.SetWantsMouseNotifications( false );
      modulationFeedbackKnob.SetPosition( 62, 290 );
      modulationFeedbackKnob.SetSize( 27, 27 );
      modulationFeedbackKnob.SetSkin( "Plastic White" );
      modulationFeedbackKnob.SetRange( -2, 2, 0, false, 0 );
      modulationFeedbackKnob.SetKnobParams( 215, 145 );
      modulationFeedbackKnob.DisplayValueInPercent( true );
      modulationFeedbackKnob.SetKnobAdjustsRing( true );

      textLabel17 = new VoltageLabel( "textLabel17", "textLabel17", this, "AMP" );
      AddComponent( textLabel17 );
      textLabel17.SetWantsMouseNotifications( false );
      textLabel17.SetPosition( 46, 120 );
      textLabel17.SetSize( 40, 15 );
      textLabel17.SetEditable( false, false );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel17.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel17.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel17.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel17.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel17.SetBorderSize( 1 );
      textLabel17.SetMultiLineEdit( false );
      textLabel17.SetIsNumberEditor( false );
      textLabel17.SetNumberEditorRange( 0, 100 );
      textLabel17.SetNumberEditorInterval( 1 );
      textLabel17.SetNumberEditorUsesMouseWheel( false );
      textLabel17.SetHasCustomTextHoverColor( false );
      textLabel17.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel17.SetFont( "Arial", 10, true, false );

      modulationAmpCv = new VoltageAudioJack( "modulationAmpCv", "Modulation Amp CV", this, JackType.JackType_AudioInput );
      AddComponent( modulationAmpCv );
      modulationAmpCv.SetWantsMouseNotifications( false );
      modulationAmpCv.SetPosition( 116, 92 );
      modulationAmpCv.SetSize( 25, 25 );
      modulationAmpCv.SetSkin( "Jack Round Cream Ring" );

      textLabel18 = new VoltageLabel( "textLabel18", "textLabel18", this, "AMP CV" );
      AddComponent( textLabel18 );
      textLabel18.SetWantsMouseNotifications( false );
      textLabel18.SetPosition( 116, 120 );
      textLabel18.SetSize( 40, 15 );
      textLabel18.SetEditable( false, false );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel18.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel18.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel18.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel18.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel18.SetBorderSize( 1 );
      textLabel18.SetMultiLineEdit( false );
      textLabel18.SetIsNumberEditor( false );
      textLabel18.SetNumberEditorRange( 0, 100 );
      textLabel18.SetNumberEditorInterval( 1 );
      textLabel18.SetNumberEditorUsesMouseWheel( false );
      textLabel18.SetHasCustomTextHoverColor( false );
      textLabel18.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel18.SetFont( "Arial", 10, true, false );

      textLabel19 = new VoltageLabel( "textLabel19", "textLabel19", this, "AMP" );
      AddComponent( textLabel19 );
      textLabel19.SetWantsMouseNotifications( false );
      textLabel19.SetPosition( 154, 120 );
      textLabel19.SetSize( 40, 15 );
      textLabel19.SetEditable( false, false );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel19.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel19.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel19.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel19.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel19.SetBorderSize( 1 );
      textLabel19.SetMultiLineEdit( false );
      textLabel19.SetIsNumberEditor( false );
      textLabel19.SetNumberEditorRange( 0, 100 );
      textLabel19.SetNumberEditorInterval( 1 );
      textLabel19.SetNumberEditorUsesMouseWheel( false );
      textLabel19.SetHasCustomTextHoverColor( false );
      textLabel19.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel19.SetFont( "Arial", 10, true, false );

      modulationAmpKnob = new VoltageKnob( "modulationAmpKnob", "Modulation Amp", this, -2, 2, 1 );
      AddComponent( modulationAmpKnob );
      modulationAmpKnob.SetWantsMouseNotifications( false );
      modulationAmpKnob.SetPosition( 160, 90 );
      modulationAmpKnob.SetSize( 27, 27 );
      modulationAmpKnob.SetSkin( "Plastic White" );
      modulationAmpKnob.SetRange( -2, 2, 1, false, 0 );
      modulationAmpKnob.SetKnobParams( 215, 145 );
      modulationAmpKnob.DisplayValueInPercent( true );
      modulationAmpKnob.SetKnobAdjustsRing( true );

      outputShapingSwitch = new VoltageSwitch( "outputShapingSwitch", "Output Shaping Switch", this, 2 );
      AddComponent( outputShapingSwitch );
      outputShapingSwitch.SetWantsMouseNotifications( false );
      outputShapingSwitch.SetPosition( 154, 242 );
      outputShapingSwitch.SetSize( 13, 31 );
      outputShapingSwitch.SetSkin( "3-State Slide Black" );

      textLabel20 = new VoltageLabel( "textLabel20", "textLabel20", this, "CLIP" );
      AddComponent( textLabel20 );
      textLabel20.SetWantsMouseNotifications( false );
      textLabel20.SetPosition( 178, 236 );
      textLabel20.SetSize( 30, 15 );
      textLabel20.SetEditable( false, false );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.Left );
      textLabel20.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel20.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel20.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel20.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel20.SetBorderSize( 1 );
      textLabel20.SetMultiLineEdit( false );
      textLabel20.SetIsNumberEditor( false );
      textLabel20.SetNumberEditorRange( 0, 100 );
      textLabel20.SetNumberEditorInterval( 1 );
      textLabel20.SetNumberEditorUsesMouseWheel( false );
      textLabel20.SetHasCustomTextHoverColor( false );
      textLabel20.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel20.SetFont( "Arial", 10, true, false );

      textLabel21 = new VoltageLabel( "textLabel21", "textLabel21", this, "FOLD" );
      AddComponent( textLabel21 );
      textLabel21.SetWantsMouseNotifications( false );
      textLabel21.SetPosition( 178, 250 );
      textLabel21.SetSize( 30, 15 );
      textLabel21.SetEditable( false, false );
      textLabel21.SetJustificationFlags( VoltageLabel.Justification.Left );
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
      textLabel21.SetFont( "Arial", 10, true, false );

      textLabel22 = new VoltageLabel( "textLabel22", "textLabel22", this, "SAT" );
      AddComponent( textLabel22 );
      textLabel22.SetWantsMouseNotifications( false );
      textLabel22.SetPosition( 178, 265 );
      textLabel22.SetSize( 30, 15 );
      textLabel22.SetEditable( false, false );
      textLabel22.SetJustificationFlags( VoltageLabel.Justification.Left );
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
      textLabel22.SetFont( "Arial", 10, true, false );

      outputMeter = new VoltageVUMeter( "outputMeter", "Output Meter", this );
      AddComponent( outputMeter );
      outputMeter.SetWantsMouseNotifications( false );
      outputMeter.SetPosition( 190, 292 );
      outputMeter.SetSize( 15, 41 );
      outputMeter.SetSkin( "Small Meter" );
      outputMeter.SetLinearMode( false );

      textLabel23 = new VoltageLabel( "textLabel23", "textLabel23", this, "OUTPUT" );
      AddComponent( textLabel23 );
      textLabel23.SetWantsMouseNotifications( false );
      textLabel23.SetPosition( 108, 220 );
      textLabel23.SetSize( 108, 15 );
      textLabel23.SetEditable( false, false );
      textLabel23.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
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
      textLabel23.SetFont( "Arial", 10, true, false );

      textLabel28 = new VoltageLabel( "textLabel28", "textLabel28", this, "FEEDBACK" );
      AddComponent( textLabel28 );
      textLabel28.SetWantsMouseNotifications( false );
      textLabel28.SetPosition( 0, 220 );
      textLabel28.SetSize( 108, 15 );
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
      textLabel28.SetFont( "Arial", 10, true, false );

      textLabel29 = new VoltageLabel( "textLabel29", "textLabel29", this, "CARRIER" );
      AddComponent( textLabel29 );
      textLabel29.SetWantsMouseNotifications( false );
      textLabel29.SetPosition( 0, 270 );
      textLabel29.SetSize( 108, 15 );
      textLabel29.SetEditable( false, false );
      textLabel29.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel29.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel29.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel29.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel29.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel29.SetBorderSize( 1 );
      textLabel29.SetMultiLineEdit( false );
      textLabel29.SetIsNumberEditor( false );
      textLabel29.SetNumberEditorRange( 0, 100 );
      textLabel29.SetNumberEditorInterval( 1 );
      textLabel29.SetNumberEditorUsesMouseWheel( false );
      textLabel29.SetHasCustomTextHoverColor( false );
      textLabel29.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel29.SetFont( "Arial", 10, true, false );

      textLabel30 = new VoltageLabel( "textLabel30", "textLabel30", this, "MODULATION" );
      AddComponent( textLabel30 );
      textLabel30.SetWantsMouseNotifications( false );
      textLabel30.SetPosition( 1, 320 );
      textLabel30.SetSize( 108, 15 );
      textLabel30.SetEditable( false, false );
      textLabel30.SetJustificationFlags( VoltageLabel.Justification.HorizCentered );
      textLabel30.SetJustificationFlags( VoltageLabel.Justification.VertCentered );
      textLabel30.SetColor( new Color( 255, 255, 255, 255 ) );
      textLabel30.SetBkColor( new Color( 65, 65, 65, 0 ) );
      textLabel30.SetBorderColor( new Color( 0, 0, 0, 0 ) );
      textLabel30.SetBorderSize( 1 );
      textLabel30.SetMultiLineEdit( false );
      textLabel30.SetIsNumberEditor( false );
      textLabel30.SetNumberEditorRange( 0, 100 );
      textLabel30.SetNumberEditorInterval( 1 );
      textLabel30.SetNumberEditorUsesMouseWheel( false );
      textLabel30.SetHasCustomTextHoverColor( false );
      textLabel30.SetTextHoverColor( new Color( 0, 0, 0, 255 ) );
      textLabel30.SetFont( "Arial", 10, true, false );

      textLabel24 = new VoltageLabel( "textLabel24", "textLabel24", this, "OUT" );
      AddComponent( textLabel24 );
      textLabel24.SetWantsMouseNotifications( false );
      textLabel24.SetPosition( 116, 270 );
      textLabel24.SetSize( 40, 15 );
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
      textLabel24.SetFont( "Arial", 10, true, false );

      outputAmpCv = new VoltageAudioJack( "outputAmpCv", "Output Amp CV", this, JackType.JackType_AudioInput );
      AddComponent( outputAmpCv );
      outputAmpCv.SetWantsMouseNotifications( false );
      outputAmpCv.SetPosition( 116, 292 );
      outputAmpCv.SetSize( 25, 25 );
      outputAmpCv.SetSkin( "Jack Round Cream Ring" );

      outputAmpKnob = new VoltageKnob( "outputAmpKnob", "Output Amp", this, -2, 2, 1 );
      AddComponent( outputAmpKnob );
      outputAmpKnob.SetWantsMouseNotifications( false );
      outputAmpKnob.SetPosition( 160, 290 );
      outputAmpKnob.SetSize( 27, 27 );
      outputAmpKnob.SetSkin( "Plastic White" );
      outputAmpKnob.SetRange( -2, 2, 1, false, 0 );
      outputAmpKnob.SetKnobParams( 215, 145 );
      outputAmpKnob.DisplayValueInPercent( true );
      outputAmpKnob.SetKnobAdjustsRing( true );

      textLabel25 = new VoltageLabel( "textLabel25", "textLabel25", this, "AMP CV" );
      AddComponent( textLabel25 );
      textLabel25.SetWantsMouseNotifications( false );
      textLabel25.SetPosition( 116, 320 );
      textLabel25.SetSize( 40, 15 );
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
      textLabel25.SetFont( "Arial", 10, true, false );

      textLabel26 = new VoltageLabel( "textLabel26", "textLabel26", this, "AMP" );
      AddComponent( textLabel26 );
      textLabel26.SetWantsMouseNotifications( false );
      textLabel26.SetPosition( 154, 320 );
      textLabel26.SetSize( 40, 15 );
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
      textLabel26.SetFont( "Arial", 10, true, false );

      tormentSelector = new VoltageKnob( "tormentSelector", "Torment Selector", this, 0.0, 5, 0 );
      AddComponent( tormentSelector );
      tormentSelector.SetWantsMouseNotifications( false );
      tormentSelector.SetPosition( 74, 156 );
      tormentSelector.SetSize( 67, 67 );
      tormentSelector.SetSkin( "Pointer Knob" );
      tormentSelector.SetRingSkin( "Crescent Black/Red" );
      tormentSelector.SetRange( 0.0, 5, 0, false, 6 );
      tormentSelector.SetKnobParams( 215, 145 );
      tormentSelector.DisplayValueInPercent( false );
      tormentSelector.SetKnobAdjustsRing( true );

      rectifyModulationSwitch = new VoltageSwitch( "rectifyModulationSwitch", "Rectify Modulation", this, 0 );
      AddComponent( rectifyModulationSwitch );
      rectifyModulationSwitch.SetWantsMouseNotifications( false );
      rectifyModulationSwitch.SetPosition( 166, 138 );
      rectifyModulationSwitch.SetSize( 20, 11 );
      rectifyModulationSwitch.SetSkin( "2-State Slide Horizontal" );

      rectifyCarrierSwitch = new VoltageSwitch( "rectifyCarrierSwitch", "Rectify Carrier", this, 0 );
      AddComponent( rectifyCarrierSwitch );
      rectifyCarrierSwitch.SetWantsMouseNotifications( false );
      rectifyCarrierSwitch.SetPosition( 58, 138 );
      rectifyCarrierSwitch.SetSize( 20, 11 );
      rectifyCarrierSwitch.SetSkin( "2-State Slide Horizontal" );

      dcBiasSwitch = new VoltageSwitch( "dcBiasSwitch", "Remove DC Bias", this, 0 );
      AddComponent( dcBiasSwitch );
      dcBiasSwitch.SetWantsMouseNotifications( false );
      dcBiasSwitch.SetPosition( 190, 201 );
      dcBiasSwitch.SetSize( 20, 11 );
      dcBiasSwitch.SetSkin( "2-State Slide Horizontal" );

      oversampleButton = new VoltageToggle( "oversampleButton", "Oversample", this, false, 0 );
      AddComponent( oversampleButton );
      oversampleButton.SetWantsMouseNotifications( false );
      oversampleButton.SetPosition( 182, 156 );
      oversampleButton.SetSize( 28, 15 );
      oversampleButton.SetSkin( "Mini Rectangle Red" );
      oversampleButton.ShowOverlay( true );
      oversampleButton.SetOverlayText( "8X" );
      oversampleButton.SetOverlayTextFont( "Arial", 10, true, false );
      oversampleButton.SetOverlayTextColor( new Color( 255, 255, 255 ) );
      oversampleButton.SetOverlayArea( 0, 0, 0, 0 );
      oversampleButton.SetOverlayTextJustification( VoltageButton.Justification.Centered );

      carrierAmpCvAmount = new VoltageKnob( "carrierAmpCvAmount", "Carrier Amp CV Amount", this, -1, 1, 0 );
      AddComponent( carrierAmpCvAmount );
      carrierAmpCvAmount.SetWantsMouseNotifications( false );
      carrierAmpCvAmount.SetPosition( 35, 84 );
      carrierAmpCvAmount.SetSize( 18, 18 );
      carrierAmpCvAmount.SetSkin( "ARP2500 Sm Red" );
      carrierAmpCvAmount.SetRange( -1, 1, 0, false, 0 );
      carrierAmpCvAmount.SetKnobParams( 215, 145 );
      carrierAmpCvAmount.DisplayValueInPercent( false );
      carrierAmpCvAmount.SetKnobAdjustsRing( true );

      carrierFeedbackCvAmount = new VoltageKnob( "carrierFeedbackCvAmount", "Carrier Feedback CV Amount", this, -1, 1, 0 );
      AddComponent( carrierFeedbackCvAmount );
      carrierFeedbackCvAmount.SetWantsMouseNotifications( false );
      carrierFeedbackCvAmount.SetPosition( 45, 235 );
      carrierFeedbackCvAmount.SetSize( 18, 18 );
      carrierFeedbackCvAmount.SetSkin( "ARP2500 Sm Red" );
      carrierFeedbackCvAmount.SetRange( -1, 1, 0, false, 0 );
      carrierFeedbackCvAmount.SetKnobParams( 215, 145 );
      carrierFeedbackCvAmount.DisplayValueInPercent( false );
      carrierFeedbackCvAmount.SetKnobAdjustsRing( true );

      modulationFeedbackCvAmount = new VoltageKnob( "modulationFeedbackCvAmount", "Modulation Feedback CV Amount", this, -1, 1, 0 );
      AddComponent( modulationFeedbackCvAmount );
      modulationFeedbackCvAmount.SetWantsMouseNotifications( false );
      modulationFeedbackCvAmount.SetPosition( 45, 284 );
      modulationFeedbackCvAmount.SetSize( 18, 18 );
      modulationFeedbackCvAmount.SetSkin( "ARP2500 Sm Red" );
      modulationFeedbackCvAmount.SetRange( -1, 1, 0, false, 0 );
      modulationFeedbackCvAmount.SetKnobParams( 215, 145 );
      modulationFeedbackCvAmount.DisplayValueInPercent( false );
      modulationFeedbackCvAmount.SetKnobAdjustsRing( true );

      outputAmpCvAmount = new VoltageKnob( "outputAmpCvAmount", "Output Amp CV Amount", this, -1, 1, 0 );
      AddComponent( outputAmpCvAmount );
      outputAmpCvAmount.SetWantsMouseNotifications( false );
      outputAmpCvAmount.SetPosition( 143, 284 );
      outputAmpCvAmount.SetSize( 18, 18 );
      outputAmpCvAmount.SetSkin( "ARP2500 Sm Red" );
      outputAmpCvAmount.SetRange( -1, 1, 0, false, 0 );
      outputAmpCvAmount.SetKnobParams( 215, 145 );
      outputAmpCvAmount.DisplayValueInPercent( false );
      outputAmpCvAmount.SetKnobAdjustsRing( true );

      modulationAmpCvAmount = new VoltageKnob( "modulationAmpCvAmount", "Modulation Amp CV Amount", this, -1, 1, 0 );
      AddComponent( modulationAmpCvAmount );
      modulationAmpCvAmount.SetWantsMouseNotifications( false );
      modulationAmpCvAmount.SetPosition( 143, 84 );
      modulationAmpCvAmount.SetSize( 18, 18 );
      modulationAmpCvAmount.SetSkin( "ARP2500 Sm Red" );
      modulationAmpCvAmount.SetRange( -1, 1, 0, false, 0 );
      modulationAmpCvAmount.SetKnobParams( 215, 145 );
      modulationAmpCvAmount.DisplayValueInPercent( false );
      modulationAmpCvAmount.SetKnobAdjustsRing( true );
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
      InputBus inputBus = connector.connectInputs(
         carrierInput,
         modulationInput,
         eventConnector.connectCvModulatableKnob(carrierAmpCv, carrierAmpCvAmount, carrierAmpKnob),
         eventConnector.connectCvModulatableKnob(modulationAmpCv, modulationAmpCvAmount, modulationAmpKnob),
         eventConnector.connectCvModulatableKnob(carrierFeedbackCv, carrierFeedbackCvAmount, carrierFeedbackKnob),
         eventConnector.connectCvModulatableKnob(modulationFeedbackCv, modulationFeedbackCvAmount, modulationFeedbackKnob),
         eventConnector.connectCvModulatableKnob(outputAmpCv, outputAmpCvAmount, outputAmpKnob)
     );

      OutputBus outputBus = connector.connectOutputs(output);
      controller = new Controller(inputBus, outputBus);
      connector.connectController(
         controller,
         carrierShapingSwitch,
         modulationShapingSwitch,
         rectifyCarrierSwitch,
         rectifyModulationSwitch,
         oversampleButton,
         dcBiasSwitch,
         outputShapingSwitch,
         tormentSelector);
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
         case Knob_Changed: return eventHandler.onKnobValueChanged(component, doubleValue);
      
         case Slider_Changed:   // doubleValue is the new slider value
         {
         }
         break;
      
         case Button_Changed: return eventHandler.onButtonChanged(component, doubleValue);
      
         case Switch_Changed: return eventHandler.onSwitchChanged(component, doubleValue);
      
         case Jack_Connected: return eventHandler.onJackConnected(component);
      
         case Jack_Disconnected: return eventHandler.onJackDisconnected(component);
      
         case GUI_Update_Timer:   // Called every 50ms (by default) if turned on
         {
            carrierMeter.SetValue(controller.getCarrierMeter());
            modulationMeter.SetValue(controller.getModulationMeter());
            outputMeter.SetValue(controller.getOutputMeter());
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
   //  public String GetTooltipText( VoltageComponent component )

      //  Gets called when a tooltip is about to display for a control. Override it if
      //  you want to change what the tooltip displays - if you want a knob to work in logarithmic fashion,
      //  for instance, you can translate the knob's current value to a log-based string and display it here.
   //-------------------------------------------------------------------------------
   @Override
   public String GetTooltipText( VoltageComponent component )
   {
      //[user-GetTooltipText]   Add your own code here
      if (component == rectifyCarrierSwitch || component == rectifyModulationSwitch
         || component == dcBiasSwitch) {
         return switch((int) component.GetValue()) {
            case 0 -> "Off";
            default -> "On";
         };
      }
      
      if (component instanceof VoltageSwitch) {
         return switch((int) component.GetValue()) {
            case 0 -> "Saturate";
            case 1 -> "Fold";
            default -> "Clip";
         };
      }
      
      if (component == tormentSelector) {
         return switch((int) component.GetValue()) {
            case 0 -> "Sum";
            case 1 -> "Amplitude Modulation";
            case 2 -> "Ring Modulation";
            case 3 -> "Analog Ring Modulation";
            case 4 -> "Delta Amplitude Modulation";
            default -> "Delta Ring Modulation";
         };
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
   private VoltageKnob modulationAmpCvAmount;
   private VoltageKnob outputAmpCvAmount;
   private VoltageKnob modulationFeedbackCvAmount;
   private VoltageKnob carrierFeedbackCvAmount;
   private VoltageKnob carrierAmpCvAmount;
   private VoltageToggle oversampleButton;
   private VoltageSwitch dcBiasSwitch;
   private VoltageSwitch rectifyCarrierSwitch;
   private VoltageSwitch rectifyModulationSwitch;
   private VoltageKnob tormentSelector;
   private VoltageLabel textLabel26;
   private VoltageLabel textLabel25;
   private VoltageKnob outputAmpKnob;
   private VoltageAudioJack outputAmpCv;
   private VoltageLabel textLabel24;
   private VoltageLabel textLabel30;
   private VoltageLabel textLabel29;
   private VoltageLabel textLabel28;
   private VoltageLabel textLabel23;
   private VoltageVUMeter outputMeter;
   private VoltageLabel textLabel22;
   private VoltageLabel textLabel21;
   private VoltageLabel textLabel20;
   private VoltageSwitch outputShapingSwitch;
   private VoltageKnob modulationAmpKnob;
   private VoltageLabel textLabel19;
   private VoltageLabel textLabel18;
   private VoltageAudioJack modulationAmpCv;
   private VoltageLabel textLabel17;
   private VoltageKnob modulationFeedbackKnob;
   private VoltageKnob carrierAmpKnob;
   private VoltageKnob carrierFeedbackKnob;
   private VoltageLabel textLabel33;
   private VoltageLabel textLabel32;
   private VoltageLabel textLabel31;
   private VoltageLabel textLabel16;
   private VoltageAudioJack modulationFeedbackCv;
   private VoltageAudioJack carrierFeedbackCv;
   private VoltageAudioJack carrierAmpCv;
   private VoltageLabel textLabel15;
   private VoltageLabel textLabel14;
   private VoltageVUMeter modulationMeter;
   private VoltageLabel textLabel27;
   private VoltageLabel textLabel13;
   private VoltageLabel textLabel12;
   private VoltageLabel textLabel11;
   private VoltageLabel textLabel10;
   private VoltageVUMeter carrierMeter;
   private VoltageLabel textLabel9;
   private VoltageLabel textLabel8;
   private VoltageLabel textLabel7;
   private VoltageSwitch carrierShapingSwitch;
   private VoltageLabel textLabel6;
   private VoltageLabel textLabel5;
   private VoltageLabel textLabel4;
   private VoltageSwitch modulationShapingSwitch;
   private VoltageAudioJack output;
   private VoltageAudioJack modulationInput;
   private VoltageAudioJack carrierInput;


   //[user-code-and-variables]    Add your own variables and functions here
private Controller controller;
private final EventBus eventBus = new EventBus();
private final UIEventConnector eventConnector = new UIEventConnector(eventBus);
private final Connector connector = new Connector(eventConnector);
private final UIEventHandler eventHandler = new UIEventHandler(eventBus);




   //[/user-code-and-variables]
}

 