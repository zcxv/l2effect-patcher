class 342 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect29
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.bl_berserker_spirit_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect30
		AttachOn=AM_LA
		EffectClass=Class'LineageEffect.at_shock_blast_ta'
	End Object
	Desc="터치 오브 데스" //Touch of Death
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect29',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect30',SpecificStage=0)
}