class 254 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect0
		AttachOn=AM_Location
		bSizeScale=True
		EffectClass=Class'LineageEffect.dw_spoil_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect1
		AttachOn=AM_RA
		AttachBoneName="e_bone"
		bAbsolute=True
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.dw_spoil_ta'
	End Object
	Desc="스포일" //Spoil
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect0',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect1',SpecificStage=0)
}